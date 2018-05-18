import cn.edu.hfut.dmic.htmlbot.contentextractor.ContentExtractor;

import java.util.Map;

public class Main {
    public static void main(String args[]) throws Exception {
        String content = ContentExtractor.getContentByURL("https://edition.cnn.com/2018/05/17/asia/xi-jinping-marxism-china-intl/index.html");

        ISegmenter iSegmenter  = new EnglishSegmenter();

        Map<String,Integer> map = iSegmenter.getSegmentResult(content);
        for(String key : map.keySet()){
            if(key != null && !key.equals(" ")) {
                log(key);
                log(map.get(key));
                System.out.print("\n");
            }
        }
    }

    private static void log(Object o){
        System.out.print(o+ "  ");
    }


}
