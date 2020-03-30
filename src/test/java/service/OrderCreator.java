package service;

import model.Order;

public class OrderCreator {

    private static final String HOMEPAGE_URL = "testdata.order.homepage_url";
    private static final String SEARCH_QUERY = "testdata.order.search_query";
    private static final String NUMBER_OF_INSTANCES = "testdata.order.number_of_instances";
    private static final String OPERATING_SYSTEM = "testdata.order.operating_system";
    private static final String VM_CLASS = "testdata.order.vm_class";
    private static final String INSTANCE_TYPE = "testdata.order.instance_type";
    private static final String NUMBER_OF_GPU = "testdata.order.number_of_gpu";
    private static final String GPU_TYPE = "testdata.order.gpu_type";
    private static final String LOCAL_SSD = "testdata.order.local_ssd";
    private static final String DATA_CENTER_LOCATION = "testdata.order.data_center_location";
    private static final String COMMITTED_USAGE = "testdata.order.committed_usage";
    private static final String EXPECTED_ESTIMATE_HEADER_NAME = "testdata.order.expected_estimate_header_name";

    public static Order withCredentialsFromProperty() {
        return new Order(TestDataReader.getTestData(HOMEPAGE_URL),
            TestDataReader.getTestData(SEARCH_QUERY),
            TestDataReader.getTestData(NUMBER_OF_INSTANCES),
            TestDataReader.getTestData(OPERATING_SYSTEM),
            TestDataReader.getTestData(VM_CLASS),
            TestDataReader.getTestData(INSTANCE_TYPE),
            TestDataReader.getTestData(NUMBER_OF_GPU),
            TestDataReader.getTestData(GPU_TYPE),
            TestDataReader.getTestData(LOCAL_SSD),
            TestDataReader.getTestData(DATA_CENTER_LOCATION),
            TestDataReader.getTestData(COMMITTED_USAGE),
            TestDataReader.getTestData(EXPECTED_ESTIMATE_HEADER_NAME));
    }
}
