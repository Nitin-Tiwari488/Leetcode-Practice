class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String , List<String>> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            String s = strs[i];
            
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!mp.containsKey(key)){
                mp.put(key , new ArrayList<>());
            }
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}