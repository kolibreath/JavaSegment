import java.util.Map;

public abstract class ISegmenter {

    abstract Map<String,Integer> getSegmentResult(String webContent);
}
