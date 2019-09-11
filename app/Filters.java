import play.filters.cors.CORSFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class Filters implements HttpFilters {

    @Inject
    private CORSFilter corsFilter;

    @Override
    public List<EssentialFilter> getFilters() {
        return Arrays.asList(corsFilter.asJava());
    }
}