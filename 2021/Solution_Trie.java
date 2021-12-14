import java.util.HashMap;
import java.util.Map;

public class Solution_Trie {

    static class Node{
        //자식노드
        Map<Character,Node> chiledNode = new HashMap<Character,Node>();

        //단어의 끝인지 아닌지 체크
        boolean isEndWord;
        
        //문자열의 자식노드가 같은지 체크
        int count;
    }

    static class Trie{
        //trie자료구조를 생성할 때 rootNode는 기복적으로 생성
        Node rootNode = new Node();

        //trie에 문자열 저장
        void insert(String str){
            //trie자료구조는 항상 rootnode부터 시작
            Node node = this.rootNode;

            //문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
            //없으면 자식노드 새로 생성
            for (int i = 0; i < str.length(); i++) {
                node = node.chiledNode.computeIfAbsent(str.charAt(i), key -> new Node());
            }

            //저장할 문자열의 마지막에 매핑되는 노드에 단어의 끝임을 명시
            node.isEndWord = true;
           
            node.count = 0;
        }

        //trie에서 문자열 검색
        boolean search(String str){
            //trie자료구조는 항상 rootNode부터 시작
            Node node = this.rootNode;

            //문자열의 각 단어마다 노드가 존재하는지 체크
            for (int i = 0; i < str.length(); i++) {
                //문자열의 각 단어에 매핑된 노드가 존재하면 가져오고 아니면 null
                node = node.chiledNode.getOrDefault(str.charAt(i), null);
                System.out.print(str.charAt(i));
                
                if(node == null){
                    //node가 null이면 현재 trie에 해당 문자열은 없음
                    return false;
                }

                if(node.isEndWord){
                    System.out.print(" check : " + str.toString());
                    node.count++;
                    System.out.println(" ?? " + node.count);
                    if(node.count >= 2){
                        System.out.println("!!");
                        return true;
                    }
                }

            }

            System.out.println(" nono ");
            
            boolean ans = false;
            if(node.count > 1){
                ans = true;
            }

            //문자열의 마지막 단어까지 매핑된 노드가 존재한다고 해서 무조건 문자열이 존재하는게 아님
            //ex)busy를 trie에 저장했으면, bus의 마지막 s단어에 매핀됭 노드는 존재하지만 trie에 저장된건 아님
            //  그러므로 현재 노드가 단어의 끝인지 아닌지 체크하는 변수로 리턴
            
            return ans;
    }
    }

    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789","1234"};

        System.out.println("answer : " + solution(phone_book));
    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Trie trie = new Trie();

        for (String string : phone_book) {
            trie.insert(string);
        }
        
        
        for (int i = 0; i < phone_book.length; i++) {
            if(trie.search(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    } 
}
