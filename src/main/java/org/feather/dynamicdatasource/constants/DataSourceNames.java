package org.feather.dynamicdatasource.constants;

import java.util.Arrays;
import java.util.List;

/**
 * @projectName: dynamic-datasource
 * @package: org.feather.dynamic.constants
 * @className: DataSourceNames
 * @author: feather
 * @description:
 * @since: 2023-08-09 10:21
 * @version: 1.0
 */
public interface DataSourceNames {
    String DS1 = "DS1";
    String DS2 = "DS2";

    List<String> datasourceNameList= Arrays.asList(DS1,DS2);
}
