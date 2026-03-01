package com.reports.task;

import com.reports.model.Report;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a single report generation task.
 * Implements Runnable so it can be submitted to a thread pool.
 *
 * Key behaviors:
 *  - Logs start, active thread name, and completion
 *  - Simulates processing delay of 2–4 seconds
 *  - Decrements the CountDownLatch after completion so the main
 *    thread knows when all reports are done
 */
public class ReportGenerationTask implements Runnable {

    private final Report report;
    private final CountDownLatch latch;

    public ReportGenerationTask(Report report, CountDownLatch latch) {
        this.report = report;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // ── 1. Log start ──────────────────────────────────────────────
            System.out.printf("[%-12s] ->  %s  STARTED%n", Thread.currentThread().getName(), report.getName());

            // ── 2. Simulate report generation (2–4 seconds) ───────────────
            int delay = ThreadLocalRandom.current().nextInt(2000, 4001); // ms
            Thread.sleep(delay);

            // ── 3. Log completion ─────────────────────────────────────────
            System.out.printf("[%-12s] ✔  %s  COMPLETED  (took %d ms)%n", Thread.currentThread().getName(), report.getName(), delay);

        } catch (InterruptedException e) {
              e.printStackTrace();
        } finally {
            // ── 4. Always decrement the latch, even if an error occurred ──
            latch.countDown();
            System.out.printf("[%-12s]    Latch count → %d%n", Thread.currentThread().getName(), latch.getCount());
        }
    }
}





