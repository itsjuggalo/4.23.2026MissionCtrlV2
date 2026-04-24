package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.TransactionOptions;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class TransactionRunner<TResult> {
    private AsyncQueue asyncQueue;
    private int attemptsRemaining;
    private ExponentialBackoff backoff;
    private RemoteStore remoteStore;
    private TaskCompletionSource<TResult> taskSource = new TaskCompletionSource<>();
    private Function<Transaction, Task<TResult>> updateFunction;

    public TransactionRunner(AsyncQueue asyncQueue, RemoteStore remoteStore, TransactionOptions transactionOptions, Function<Transaction, Task<TResult>> function) {
        this.asyncQueue = asyncQueue;
        this.remoteStore = remoteStore;
        this.updateFunction = function;
        this.attemptsRemaining = transactionOptions.getMaxAttempts();
        this.backoff = new ExponentialBackoff(asyncQueue, AsyncQueue.TimerId.RETRY_TRANSACTION);
    }

    public static /* synthetic */ void a(final TransactionRunner transactionRunner, Transaction transaction, final Task task) {
        transactionRunner.getClass();
        if (task.isSuccessful()) {
            transaction.commit().addOnCompleteListener(transactionRunner.asyncQueue.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.core.F
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    TransactionRunner.c(this.f10410a, task, task2);
                }
            });
        } else {
            transactionRunner.handleTransactionError(task);
        }
    }

    public static /* synthetic */ void b(final TransactionRunner transactionRunner) {
        final Transaction transactionCreateTransaction = transactionRunner.remoteStore.createTransaction();
        transactionRunner.updateFunction.apply(transactionCreateTransaction).addOnCompleteListener(transactionRunner.asyncQueue.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.core.G
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TransactionRunner.a(this.f10412a, transactionCreateTransaction, task);
            }
        });
    }

    public static /* synthetic */ void c(TransactionRunner transactionRunner, Task task, Task task2) {
        transactionRunner.getClass();
        if (task2.isSuccessful()) {
            transactionRunner.taskSource.setResult((TResult) task.getResult());
        } else {
            transactionRunner.handleTransactionError(task2);
        }
    }

    private void handleTransactionError(Task task) {
        if (this.attemptsRemaining <= 0 || !isRetryableTransactionError(task.getException())) {
            this.taskSource.setException(task.getException());
        } else {
            runWithBackoff();
        }
    }

    private static boolean isRetryableTransactionError(Exception exc) {
        if (!(exc instanceof FirebaseFirestoreException)) {
            return false;
        }
        FirebaseFirestoreException firebaseFirestoreException = (FirebaseFirestoreException) exc;
        FirebaseFirestoreException.Code code = firebaseFirestoreException.getCode();
        return code == FirebaseFirestoreException.Code.ABORTED || code == FirebaseFirestoreException.Code.ALREADY_EXISTS || code == FirebaseFirestoreException.Code.FAILED_PRECONDITION || !Datastore.isPermanentError(firebaseFirestoreException.getCode());
    }

    private void runWithBackoff() {
        this.attemptsRemaining--;
        this.backoff.backoffAndRun(new Runnable() { // from class: com.google.firebase.firestore.core.H
            @Override // java.lang.Runnable
            public final void run() {
                TransactionRunner.b(this.f10414a);
            }
        });
    }

    public Task<TResult> run() {
        runWithBackoff();
        return this.taskSource.getTask();
    }
}
