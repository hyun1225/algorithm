package programmers.kakao_recruitment;

import java.util.ArrayList;
import java.util.*;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;

public class programmers_순위검색 {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Map<String, List<Integer>> map = new HashMap<>();
	static int[] answer;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/programmers_input/programmers_input_.txt"));

		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", 
						"python frontend senior chicken 150", "cpp backend senior pizza 260", 
						"java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", 
							"cpp and - and senior and pizza 250", "- and backend and senior and - 150", 
							"- and - and - and chicken 100", "- and - and - and - 150"};
		answer = new int[query.length];
		setInfo(info);
		makeAnswer(query);
		//return answer;
		
		for(int i = 0 ; i < answer.length ; i ++) {
			System.out.print(answer[i]+", ");
		}

	}
	
	static void dfs(String str,int depth,String[] info){
        if(depth==4){
            if(map.containsKey(str)==false){
                List<Integer> list=new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str,list);
            }else{
                map.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }
        String strPlus = str+"-";
        dfs(strPlus,depth+1,info);
        
        strPlus = str+info[depth];
        dfs(strPlus,depth+1,info);
    }
    
    static void setInfo(String[] info){
        for(int i=0;i<info.length;i++){
        	String[] str = info[i].split(" ");
            dfs("",0,str);
        }
        
        Iterator<String> it= map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            List<Integer> li=map.get(key);
            Collections.sort(li);
        }
    }
    
    static int counting(String str,int score){
        if(map.containsKey(str)==false) return 0;
        
        List<Integer> list=map.get(str);
        int start=0,end=list.size()-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            if(list.get(mid)<score){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        
        return list.size()-start;
    }
    
    static void makeAnswer(String[] query){
        for(int i=0;i<query.length;i++){
            String str="";
            String[] arr=query[i].split(" ");
            
            for(int j=0;j<arr.length-1;j++){
                if(arr[j].equals("and")) continue; 
                str+=arr[j];
            }
            answer[i]=counting(str,Integer.parseInt(arr[arr.length-1]));
        }
    }

}

