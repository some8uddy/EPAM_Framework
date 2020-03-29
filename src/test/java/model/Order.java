package model;

import java.util.Objects;

public class Order {
    private String HOMEPAGE_URL;
    private String SEARCH_QUERY;
    private String NUMBER_OF_INSTANCES;
    private String OPERATING_SYSTEM;
    private String VM_CLASS;
    private String INSTANCE_TYPE;
    private String NUMBER_OF_GPU;
    private String GPU_TYPE;
    private String LOCAL_SSD;
    private String DATACENTER_LOCATION;
    private String COMMITED_USAGE;
    private String EXPECTED_ESTIMATE_HEADER_NAME;

    public Order(String HOMEPAGE_URL,
                 String SEARCH_QUERY,
                 String NUMBER_OF_INSTANCES,
                 String OPERATING_SYSTEM,
                 String VM_CLASS,
                 String INSTANCE_TYPE,
                 String NUMBER_OF_GPU,
                 String GPU_TYPE,
                 String LOCAL_SSD,
                 String DATACENTER_LOCATION,
                 String COMMITED_USAGE,
                 String EXPECTED_ESTIMATE_HEADER_NAME) {
        this.HOMEPAGE_URL = HOMEPAGE_URL;
        this.SEARCH_QUERY = SEARCH_QUERY;
        this.NUMBER_OF_INSTANCES = NUMBER_OF_INSTANCES;
        this.OPERATING_SYSTEM = OPERATING_SYSTEM;
        this.VM_CLASS = VM_CLASS;
        this.INSTANCE_TYPE = INSTANCE_TYPE;
        this.NUMBER_OF_GPU = NUMBER_OF_GPU;
        this.GPU_TYPE = GPU_TYPE;
        this.LOCAL_SSD = LOCAL_SSD;
        this.DATACENTER_LOCATION = DATACENTER_LOCATION;
        this.COMMITED_USAGE = COMMITED_USAGE;
        this.EXPECTED_ESTIMATE_HEADER_NAME = EXPECTED_ESTIMATE_HEADER_NAME;
    }

    public String getHomePageUrl() {
        return HOMEPAGE_URL;
    }

    public String getSearchQuery() {
        return SEARCH_QUERY;
    }

    public String getNumberOfInstances() {
        return NUMBER_OF_INSTANCES;
    }

    public String getOperatingSystem() {
        return OPERATING_SYSTEM;
    }

    public String getVmClass() {
        return VM_CLASS;
    }

    public String getInstanceType() {
        return INSTANCE_TYPE;
    }

    public String getNumberOfGpu() {
        return NUMBER_OF_GPU;
    }

    public String getGpuType() {
        return GPU_TYPE;
    }

    public String getLocalSsd() {
        return LOCAL_SSD;
    }

    public String getDatacenterLocation() {
        return DATACENTER_LOCATION;
    }

    public String getCommitedUsage() {
        return COMMITED_USAGE;
    }

    public String getExpectedEstimateHeaderName() {
        return EXPECTED_ESTIMATE_HEADER_NAME;
    }

    @Override
    public String toString() {
        return "Order{" +
            "HOMEPAGE_URL='" + HOMEPAGE_URL + '\'' +
            ", SEARCH_QUERY='" + SEARCH_QUERY + '\'' +
            ", NUMBER_OF_INSTANCES='" + NUMBER_OF_INSTANCES + '\'' +
            ", OPERATING_SYSTEM='" + OPERATING_SYSTEM + '\'' +
            ", VM_CLASS='" + VM_CLASS + '\'' +
            ", INSTANCE_TYPE='" + INSTANCE_TYPE + '\'' +
            ", NUMBER_OF_GPU='" + NUMBER_OF_GPU + '\'' +
            ", GPU_TYPE='" + GPU_TYPE + '\'' +
            ", LOCAL_SSD='" + LOCAL_SSD + '\'' +
            ", DATACENTER_LOCATION='" + DATACENTER_LOCATION + '\'' +
            ", COMMITED_USAGE='" + COMMITED_USAGE + '\'' +
            ", EXPECTED_ESTIMATE_HEADER_NAME='" + EXPECTED_ESTIMATE_HEADER_NAME + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(HOMEPAGE_URL, order.HOMEPAGE_URL) &&
            Objects.equals(SEARCH_QUERY, order.SEARCH_QUERY) &&
            Objects.equals(NUMBER_OF_INSTANCES, order.NUMBER_OF_INSTANCES) &&
            Objects.equals(OPERATING_SYSTEM, order.OPERATING_SYSTEM) &&
            Objects.equals(VM_CLASS, order.VM_CLASS) &&
            Objects.equals(INSTANCE_TYPE, order.INSTANCE_TYPE) &&
            Objects.equals(NUMBER_OF_GPU, order.NUMBER_OF_GPU) &&
            Objects.equals(GPU_TYPE, order.GPU_TYPE) &&
            Objects.equals(LOCAL_SSD, order.LOCAL_SSD) &&
            Objects.equals(DATACENTER_LOCATION, order.DATACENTER_LOCATION) &&
            Objects.equals(COMMITED_USAGE, order.COMMITED_USAGE) &&
            Objects.equals(EXPECTED_ESTIMATE_HEADER_NAME, order.EXPECTED_ESTIMATE_HEADER_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HOMEPAGE_URL, SEARCH_QUERY, NUMBER_OF_INSTANCES, OPERATING_SYSTEM, VM_CLASS, INSTANCE_TYPE, NUMBER_OF_GPU, GPU_TYPE, LOCAL_SSD, DATACENTER_LOCATION, COMMITED_USAGE, EXPECTED_ESTIMATE_HEADER_NAME);
    }
}
