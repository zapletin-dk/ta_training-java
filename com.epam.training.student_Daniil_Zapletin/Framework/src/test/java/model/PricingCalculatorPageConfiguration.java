package model;

import java.util.Objects;

public class PricingCalculatorPageConfiguration {
    private final String numberOfInstances;
    private final String operatingSystem;
    private final String provisioningModel;
    private final String machineFamily;
    private final String series;
    private final String machineType;
    private final String numberOfGPU;
    private final String typeOfGPU;
    private final String capacityOfLocalSSD;
    private final String locationOfDataCenter;
    private final String committedUsage;
    private final String totalEstimate;

    public PricingCalculatorPageConfiguration(String numberOfInstances, String operatingSystem, String provisioningModel,
                                              String machineFamily, String series, String machineType, String numberOfGPU,
                                              String typeOfGPU, String capacityOfLocalSSD, String locationOfDataCenter,
                                              String committedUsage, String totalEstimate) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.numberOfGPU = numberOfGPU;
        this.typeOfGPU = typeOfGPU;
        this.capacityOfLocalSSD = capacityOfLocalSSD;
        this.locationOfDataCenter = locationOfDataCenter;
        this.committedUsage = committedUsage;
        this.totalEstimate = totalEstimate;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public String getCapacityOfLocalSSD() {
        return capacityOfLocalSSD;
    }

    public String getLocationOfDataCenter() {
        return locationOfDataCenter;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getTotalEstimate(){
        return totalEstimate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingCalculatorPageConfiguration that = (PricingCalculatorPageConfiguration) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances)
                && Objects.equals(operatingSystem, that.operatingSystem)
                && Objects.equals(provisioningModel, that.provisioningModel)
                && Objects.equals(machineFamily, that.machineFamily)
                && Objects.equals(series, that.series)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(numberOfGPU, that.numberOfGPU)
                && Objects.equals(typeOfGPU, that.typeOfGPU)
                && Objects.equals(capacityOfLocalSSD, that.capacityOfLocalSSD)
                && Objects.equals(locationOfDataCenter, that.locationOfDataCenter)
                && Objects.equals(committedUsage, that.committedUsage)
                && Objects.equals(totalEstimate, that.totalEstimate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, provisioningModel, machineFamily, series, machineType,
                numberOfGPU, typeOfGPU, capacityOfLocalSSD, locationOfDataCenter, committedUsage, totalEstimate);
    }

    @Override
    public String toString() {
        return "PricingCalculatorPageConfiguration{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGPU='" + numberOfGPU + '\'' +
                ", typeOfGPU='" + typeOfGPU + '\'' +
                ", capacityOfLocalSSD='" + capacityOfLocalSSD + '\'' +
                ", locationOfDataCenter='" + locationOfDataCenter + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", totalEstimate='" + totalEstimate + '\'' +
                '}';
    }
}
