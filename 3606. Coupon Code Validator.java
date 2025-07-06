class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> set = new HashSet<>();
        set.add("electronics"); set.add("grocery"); set.add("pharmacy"); set.add("restaurant");
        List<String> electronics = new ArrayList<>(), grocery = new ArrayList<>(), pharmacy = new ArrayList<>(), restaurant = new ArrayList<>();
        for(int i=0; i<code.length; i++){
            boolean include = true;
            if(code[i].length() == 0) include = false;
            for(char c : code[i].toCharArray()){
                if(!Character.isDigit(c) && !Character.isLetter(c) && c != '_'){
                    include = false;
                    break;
                }
            }
            if(!set.contains(businessLine[i])) include = false;
            if(!isActive[i]) include = false;
            if(include){
                if(businessLine[i].equals("electronics")) electronics.add(code[i]);
                else if(businessLine[i].equals("grocery")) grocery.add(code[i]);
                else if(businessLine[i].equals("pharmacy")) pharmacy.add(code[i]);
                else restaurant.add(code[i]);
            }
        }
        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);
        List<String> list = new ArrayList<>();
        list.addAll(electronics);
        list.addAll(grocery);
        list.addAll(pharmacy);
        list.addAll(restaurant);
        return list;
    }
}
