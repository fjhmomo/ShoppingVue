//package com.example.demo.utils;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ResourceWatcher {
//    private String resourceDirectory;
//    private Map<String, Long> sizeRecords;
//
//    public ResourceWatcher(String resourceDirectory) {
//        this.resourceDirectory = resourceDirectory;
//        this.sizeRecords = new HashMap<>();
//    }
//
//    public void startWatching() {
//        while (true) {
//            watchResourceDirectory();
//            try {
//                Thread.sleep(1000); // 每隔一秒检查一次
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void watchResourceDirectory() {
//        File[] files = new File(resourceDirectory).listFiles();
//        for (File file : files) {
//            if (file.isFile()) {
//                if (isImageFile(file)) {
//                    long currentSize = file.length();
//                    long previousSize = getSizeFromRecords(file.getName());
//
//                    // Check if it's a new file
//                    if (!sizeRecords.containsKey(file.getName())) {
//                        reloadResource(file.getName());
//                        updateSizeRecords(file.getName(), currentSize);
//                    }
//
//                    if (currentSize != previousSize || isImageSizeChanged(file)) {
//                        reloadResource(file.getName());
//                        updateSizeRecords(file.getName(), currentSize);
//                    }
//                }
//            }
//        }
//    }
//
//    private boolean isImageFile(File file) {
//        String name = file.getName().toLowerCase();
//        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif");
//    }
//
//    private boolean isImageSizeChanged(File file) {
//        try {
//            BufferedImage originalImage = ImageIO.read(file);
//            int width = originalImage.getWidth();
//            int height = originalImage.getHeight();
//            // 这里可以与之前记录的图片尺寸进行比较，以判断图片的尺寸是否发生了变化
//            // 省略与之前记录比较的逻辑
//            return false; // 假设这里始终返回false，表示图片尺寸未发生变化
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false; // 图片读取失败，也视作尺寸未发生变化
//        }
//    }
//
//    private void reloadResource(String resourceName) {
//        System.out.println("Reloading resource: " + resourceName);
//        // 在这里执行重新加载资源文件的逻辑，比如重新加载图片资源到界面上
//    }
//
//    private long getSizeFromRecords(String resourceName) {
//        return sizeRecords.getOrDefault(resourceName, 0L);
//    }
//
//    private void updateSizeRecords(String resourceName, long size) {
//        sizeRecords.put(resourceName, size);
//    }
//
//    public static void main(String[] args) {
//        String resourceDirectory = "C:\\Users\\LEGION\\Desktop\\javaweb\\Springboot\\demo\\src\\main\\resources\\static\\userPic";
//        ResourceWatcher watcher = new ResourceWatcher(resourceDirectory);
//        watcher.startWatching();
//    }
//}
