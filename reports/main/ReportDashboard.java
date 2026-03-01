package com.reports.main;

import com.reports.service.ReportService;

/**
 * Entry point for the Parallel Report Generation System.
 *
 * Run this class to observe:
 *  1. Only 2 threads active at a time (thread pool behaviour)
 *  2. Main thread blocked until all 8 reports finish (CountDownLatch behaviour)
 */
public class ReportDashboard {

    public static void main(String[] args) {
        ReportService reportService = new ReportService();
        try {
            reportService.generateAllReports();
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
