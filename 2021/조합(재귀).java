class Solution2 {
    public static void main(String[] args) {
        
        String[] arr = {"a","b","c"};
        boolean[] visited = new boolean[arr.length];
        for (int i = 1; i <= arr.length; i++) {
            System.out.println(arr.length+"개중 " + i +"개뽑을때 ");
            comb(arr, visited, 0, i);
            
        }

    }

    public static void comb(String[] arr, boolean[] visited ,int depth, int r){
        if(r == 0){
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println("end");
            return;
        }

        if(depth == arr.length){
            return;
        }else{
            visited[depth] = true;
            comb(arr, visited, depth+1, r-1);

            visited[depth] = false;
            comb(arr, visited, depth+1, r);
        }
         
    }

    public int solution(String[][] clothes) {
        int answer = 0;
        return answer;
    }
}
