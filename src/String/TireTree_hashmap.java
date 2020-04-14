package String;
import java.util.*;
public class TireTree {
//    static class Tire{
//        Map<String, Tire> child;
//        boolean end;
//        Tire(){
//            child = new HashMap<>();
//            end = false;
//        }
//        public boolean createFolder(String s, int i){//i为起始位置
//            if(i>=s.length() || i==s.length()-1 && s.charAt(i)=='/')
//                return true;//字符串已经到尾巴
//            if(end)
//                return true;
//            int next = s.indexOf('/', i+1);//从当前第i个位置起的
//            if(next==-1)
//                next = s.length();//没找到说明结束直接返回末尾
//            String name = s.substring(i+1, next);//该节点字符串
//            Tire sub = child.getOrDefault(name, new Tire());//找到子Tire树
//            child.putIfAbsent(name, sub);
//            sub.end = sub.createFolder(s, next);//只有最终结束的节点才会为end=True
//            if(sub.end)
//                sub.child = new HashMap<>();
//            return false;
//        }
//
//        public void getFolder(List<String> res, StringBuilder sb){
//            if(end){//因此遇到true节点直接返回即可
//                res.add(sb.toString());
//                return ;
//            }
//            for(Map.Entry<String, Tire> es: child.entrySet()){
//                String s = es.getKey();
//                Tire t = es.getValue();
//                int l = sb.length();
//                sb.append('/');
//                sb.append(s);
//                t.getFolder(res, sb);
//                sb.delete(l, sb.length());
//            }
//        }
//
//    }
    public static List<String> removeSubfolders(String[] folder){
        Tire root = new Tire();//创建一颗Tire树
        for(String s: folder){//对每个字符串更新Tire树
            root.createFolder(s, 0);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        root.getFolder(res, sb);
        return res;
    }
    public static void main(String[] args){
        String[] ss = {"/a","/a/b","/c/d","/c/f","/c/d/e"};
        List<String> res = removeSubfolders(ss);
        for(String e: res){
            System.out.println(e);
        }
    }
    static class Tire{
        Map<String, Tire> child;
        boolean end;
        Tire(){
            child = new HashMap();
            end = false;
        }
        public boolean createFolder(String s, int i) {
            if (i >= s.length() || i == s.length() - 1 && s.charAt(i) == '/')
                return true;
            if (end)
                return true;
            int next = s.indexOf('/', i + 1);
            if (next == -1)
                next = s.length();
            String name = s.substring(i + 1, next);
            Tire sub = child.getOrDefault(name, new Tire());
            child.putIfAbsent(name, sub);
            sub.end = createFolder(s, next);
            if(sub.end)
                sub.child = new HashMap<>();
            return false;
        }

        public void getFolder(List<String> res, StringBuilder sb){
            if(end){
                res.add(sb.toString());
                return;
            }
            for(Map.Entry<String, Tire> es: child.entrySet()){
                String s = es.getKey();
                Tire t = es.getValue();
                int l = sb.length();
                sb.append('/');
                sb.append(s);
                t.getFolder(res, sb);
                sb.delete(l, sb.length());
            }


        }
    }
}
