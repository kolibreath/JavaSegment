import java.util.*;

public class EnglishSegmenter extends ISegmenter {
    @Override
    Map<String, Integer> getSegmentResult(String webContent) {
        Scanner scanner = new Scanner(webContent);

        Comparator<Map.Entry<String,Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        Map<String,Integer> map = new TreeMap<String,Integer>();

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(list,comparator);

        while(scanner.hasNext()){
            String key ;
            key = scanner.next();
            key = key.replaceAll("[^a-zA-Z]","");
            if(key.equals("")) continue;
            Integer value = map.get(key);
            value = value == null  ? 0 : value;
            value++;
            map.put(key,value);
        }
        return map;
    }
}
