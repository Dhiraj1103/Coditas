package com.reports.service;

import com.reports.model.Report;
import com.reports.task.ReportGenerationTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ReportService orchestrates the parallel generation of all reports.
 *
 * Design decisions:
 *  - Fixed thread pool of size 2  → only 2 reports run simultaneously;
 *    the remaining 6 queue up and wait for a free thread.
 *  - CountDownLatch(8)            → main thread blocks at latch.await()
 *    until every one of the 8 tasks calls latch.countDown().
 */
public class ReportService {

    private static final int TOTAL_REPORTS   = 8;
    private static final int THREAD_POOL_SIZE = 2;

    public void generateAllReports() throws InterruptedException {

        System.out.println("═".repeat(60));
        System.out.println("  Parallel Report Generation System  ");
        System.out.println("  Thread Pool Size : " + THREAD_POOL_SIZE);
        System.out.println("  Total Reports    : " + TOTAL_REPORTS);
        System.out.println("═".repeat(60));
        System.out.println();

        // ── Step 1: Create the CountDownLatch ─────────────────────────────
        // Initialized with TOTAL_REPORTS; main thread will wait at await()
        // until the count reaches zero.
        CountDownLatch latch = new CountDownLatch(TOTAL_REPORTS);

        // ── Step 2: Create a Fixed Thread Pool ────────────────────────────
        // Only 2 worker threads exist; all 8 tasks are submitted but at most
        // 2 will run concurrently — the rest wait in the internal queue.
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // ── Step 3: Build report objects ──────────────────────────────────
        List<Report> reports = new ArrayList<>();
        for (int i = 1; i <= TOTAL_REPORTS; i++) {
            reports.add(new Report(i));
        }

        // ── Step 4: Submit all tasks to the thread pool ───────────────────
        System.out.println("Submitting " + TOTAL_REPORTS + " reports to thread pool...\n");
        for (Report report : reports) {
            threadPool.submit(new ReportGenerationTask(report, latch));
        }

        // ── Step 5: Main thread waits here ────────────────────────────────
        // latch.await() BLOCKS the main thread until latch count == 0.
        System.out.println("Main thread is WAITING for all reports to complete...\n");
        latch.await();

        // ── Step 6: All reports done — print dashboard message ────────────
        System.out.println();
        System.out.println("═".repeat(60));
        System.out.println("  ✅  All reports generated. Dashboard is ready.");
        System.out.println("═".repeat(60));

        // ── Step 7: Shutdown the thread pool gracefully ───────────────────
        threadPool.shutdown();
    }
}
