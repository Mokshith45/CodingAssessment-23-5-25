import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Laptop {
    String processor;
    int ram;
    int graphics;
    int memory;
    int hardDisk;
    LocalDate manufactureDate;

    Laptop(String processor, int ram, int graphics, int memory, int hardDisk, LocalDate manufactureDate) {
        this.processor = processor;
        this.ram = ram;
        this.graphics = graphics;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.manufactureDate = manufactureDate;
    }

    public String getProcessor() { return processor; }
    public int getRam() { return ram; }
    public int getGraphics() { return graphics; }
    public int getMemory() { return memory; }
    public int getHardDisk() { return hardDisk; }
    public LocalDate getManufactureDate() { return manufactureDate; }

    @Override
    public String toString() {
        return "[" + processor + ", RAM: " + ram + "GB, GPU: " + graphics + "GB, Memory: " + memory + "GB, HDD: "
                + hardDisk + "GB, Date: " + manufactureDate + "]";
    }
}

public class SortLaptops {
    public static void main(String[] args) {
        // Step 1: Create some sample laptops
        List<Laptop> laptops = Arrays.asList(
                new Laptop("Intel i5", 8, 4, 256, 500, LocalDate.of(2022, 1, 10)),
                new Laptop("Intel i7", 16, 6, 512, 1000, LocalDate.of(2021, 5, 15)),
                new Laptop("Intel i5", 4, 2, 128, 250, LocalDate.of(2020, 3, 10)),
                new Laptop("Ryzen 5", 8, 4, 512, 1000, LocalDate.of(2022, 8, 5)),
                new Laptop("Ryzen 5", 16, 8, 1024, 2000, LocalDate.of(2023, 2, 18))
        );

        int minRam = 8;
        int minGraphics = 4;

        // Filtering laptops that meet minimum configuration
        List<Laptop> filteredLaptops = laptops.stream()
                .filter(l -> l.getRam() >= minRam && l.getGraphics() >= minGraphics)
                .collect(Collectors.toList());

        // Grouping filtered laptops by processor model
        Map<String, List<Laptop>> groupedByProcessor = filteredLaptops.stream()
                .collect(Collectors.groupingBy(Laptop::getProcessor));

        // Sorting laptops in each processor group by memory, hardDisk, manufactureDate
        groupedByProcessor.forEach((processor, laptopList) -> {
            laptopList.sort(Comparator
                    .comparingInt(Laptop::getMemory)
                    .thenComparingInt(Laptop::getHardDisk)
                    .thenComparing(Laptop::getManufactureDate));
        });

        System.out.println("Filtered and Grouped Laptops:");
        groupedByProcessor.forEach((processor, laptopList) -> {
            System.out.println("Processor: " + processor);
            laptopList.forEach(System.out::println);
            System.out.println();
        });
    }
}
