class Solution {
    public static boolean isVowel(char[] arr, int idx){
        char ch = arr[idx];
        
    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U'){
        return true;
    }else{
        return false;
    }
}
    
    public void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int l = 0;
        int r = arr.length-1;
        
        while(l < r){
            
            while(l < r && isVowel(arr, l) == false){
                l++;
            }
            while(l < r && isVowel(arr, r) == false){
                r--;
            }
            swap(arr, l, r);
            l++;
            r--;
        }
        
        String str = "";
        for(char ch:arr){
            str += ch;
        }
        return str;
    }
}
