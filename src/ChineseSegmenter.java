import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChineseSegmenter extends ISegmenter {

    @Override
    Map<String, Integer> getSegmentResult(String webContent) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        Map<String,Integer> map = new TreeMap<>();
        List<SegToken> tokens = new ArrayList<>();
        tokens = segmenter.process(webContent,JiebaSegmenter.SegMode.SEARCH);
        for(SegToken token : tokens){
            String key = token.word;
            Integer value = map.get(key);
            value = value== null ? 0 :value;
            value++;
            map.put(key,value);
        }
        return map;
    }
}
