import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseSegmenter extends ISegmenter {

    @Override
    Map<String, Integer> getSegmentResult(String webContent) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        Map<String,Integer> map = new HashMap<>();
        List<SegToken> tokens;
        tokens = segmenter.process(webContent,JiebaSegmenter.SegMode.SEARCH);


        for(SegToken token : tokens){
            String key = token.word;
            if(!isHanCharacter(key)) continue;
            Integer value = map.get(key);
            value = value== null ? 0 :value;
            value++;
            map.put(key,value);
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(new ValueComparator(map));
        sortedMap.putAll(map);
        return sortedMap;
    }

    private class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with
        // equals.
        public int compare(String a, String b) {
//            / returning 0 would merge keys
            if (base.get(a) > base.get(b)) {
                return -1;
            } else if(base.get(a) < base.get(b)){
                return 1;
            }else{
                return a.compareTo(b);
            }
        }
    }


    private boolean isHanCharacter(String word){
        String regexStr = "[\\u4E00-\\u9FA5]";
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher =  pattern.matcher(word);
        boolean flag = false;
        while(matcher.find()){
            flag = true;
        }
        return flag;
    }
}
