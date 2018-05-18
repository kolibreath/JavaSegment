import cn.edu.hfut.dmic.htmlbot.contentextractor.ContentExtractor;

import java.util.Map;

public class Main {
    public static void main(String args[]) throws Exception {
        String content = ContentExtractor.getContentByURL("http://www.ccnu.edu.cn/");

        ISegmenter iSegmenter  = new ChineseSegmenter();

        Map<String,Integer> map = iSegmenter.getSegmentResult(content);
        for(String key : map.keySet()){
                log(key);
                log(map.get(key));
                System.out.print("\n");
        }
    }

    private static void log(Object o){
        System.out.print(o+ "  ");
    }


}
