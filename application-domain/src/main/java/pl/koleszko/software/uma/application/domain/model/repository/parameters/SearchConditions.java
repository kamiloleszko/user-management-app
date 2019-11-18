package pl.koleszko.software.uma.application.domain.model.repository.parameters;

import com.google.common.collect.Maps;
import org.hibernate.Query;
import java.util.Map;

public class SearchConditions {

    private final Map<String, Object> queryParams = Maps.newHashMap();
    private String customQuery;

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public String getCustomQuery() {
        return customQuery;
    }

    public void setCustomQuery(String customQuery) {
        this.customQuery = customQuery;
    }
}
