package model;

import java.util.Objects;

public record PricingCalculatorPageConfiguration(String numberOfInstances, String operatingSystem,
                                                 String provisioningModel, String machineFamily, String series,
                                                 String machineType, String numberOfGPU, String typeOfGPU,
                                                 String capacityOfLocalSSD, String locationOfDataCenter,
                                                 String committedUsage, String totalEstimate) {

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
