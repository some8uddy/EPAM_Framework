package service;

import model.Order;

public class OrderCreator {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String OPERATING_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String VM_CLASS = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String NUMBER_OF_GPU = "1";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATACENTER_LOCATION = "Frankfurt";
    private static final String COMMITED_USAGE = "1 Year";
    private static final String EXPECTED_ESTIMATE_HEADER_NAME = "Compute Engine";

    public static Order withCredentialsFromProperty() {
        return new Order(HOMEPAGE_URL,
            SEARCH_QUERY,
            NUMBER_OF_INSTANCES,
            OPERATING_SYSTEM,
            VM_CLASS,
            INSTANCE_TYPE,
            NUMBER_OF_GPU,
            GPU_TYPE,
            LOCAL_SSD,
            DATACENTER_LOCATION,
            COMMITED_USAGE,
            EXPECTED_ESTIMATE_HEADER_NAME);
    }
}
