package com.google.firebase.storage.ktx;

import W2.E;
import W2.q;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTaskScheduler;
import com.google.firebase.storage.ktx.TaskState;
import i3.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import t3.M;
import v3.k;
import v3.u;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.storage.ktx.StorageKt$taskState$1", f = "Storage.kt", l = {352}, m = "invokeSuspend")
public final class StorageKt$taskState$1 extends l implements o {
    final /* synthetic */ StorageTask<T> $this_taskState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.google.firebase.storage.ktx.StorageKt$taskState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ OnCompleteListener<T> $completionListener;
        final /* synthetic */ OnPausedListener<T> $pauseListener;
        final /* synthetic */ OnProgressListener<T> $progressListener;
        final /* synthetic */ StorageTask<T> $this_taskState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StorageTask<T> storageTask, OnProgressListener<T> onProgressListener, OnPausedListener<T> onPausedListener, OnCompleteListener<T> onCompleteListener) {
            super(0);
            this.$this_taskState = storageTask;
            this.$progressListener = onProgressListener;
            this.$pauseListener = onPausedListener;
            this.$completionListener = onCompleteListener;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m22invoke();
            return E.f5463a;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m22invoke() {
            this.$this_taskState.removeOnProgressListener(this.$progressListener);
            this.$this_taskState.removeOnPausedListener(this.$pauseListener);
            this.$this_taskState.removeOnCompleteListener(this.$completionListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageKt$taskState$1(StorageTask<T> storageTask, Z2.e eVar) {
        super(2, eVar);
        this.$this_taskState = storageTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(final v3.s sVar, final StorageTask.SnapshotBase snapshotBase) {
        StorageTaskScheduler.getInstance().scheduleCallback(new Runnable() { // from class: com.google.firebase.storage.ktx.e
            @Override // java.lang.Runnable
            public final void run() {
                StorageKt$taskState$1.invokeSuspend$lambda$1$lambda$0(sVar, snapshotBase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1$lambda$0(v3.s sVar, StorageTask.SnapshotBase snapshotBase) {
        k.b(sVar, new TaskState.InProgress(snapshotBase));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3(final v3.s sVar, final StorageTask.SnapshotBase snapshotBase) {
        StorageTaskScheduler.getInstance().scheduleCallback(new Runnable() { // from class: com.google.firebase.storage.ktx.a
            @Override // java.lang.Runnable
            public final void run() {
                StorageKt$taskState$1.invokeSuspend$lambda$3$lambda$2(sVar, snapshotBase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3$lambda$2(v3.s sVar, StorageTask.SnapshotBase snapshotBase) {
        k.b(sVar, new TaskState.Paused(snapshotBase));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4(v3.s sVar, Task task) {
        if (task.isSuccessful()) {
            u.a.a(sVar, null, 1, null);
        } else {
            M.c(sVar, "Error getting the TaskState", task.getException());
        }
    }

    @Override // b3.AbstractC0863a
    public final Z2.e create(Object obj, Z2.e eVar) {
        StorageKt$taskState$1 storageKt$taskState$1 = new StorageKt$taskState$1(this.$this_taskState, eVar);
        storageKt$taskState$1.L$0 = obj;
        return storageKt$taskState$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.label;
        if (i4 == 0) {
            q.b(obj);
            final v3.s sVar = (v3.s) this.L$0;
            OnProgressListener onProgressListener = new OnProgressListener() { // from class: com.google.firebase.storage.ktx.b
                @Override // com.google.firebase.storage.OnProgressListener
                public final void onProgress(Object obj2) {
                    StorageKt$taskState$1.invokeSuspend$lambda$1(sVar, (StorageTask.SnapshotBase) obj2);
                }
            };
            OnPausedListener onPausedListener = new OnPausedListener() { // from class: com.google.firebase.storage.ktx.c
                @Override // com.google.firebase.storage.OnPausedListener
                public final void onPaused(Object obj2) {
                    StorageKt$taskState$1.invokeSuspend$lambda$3(sVar, (StorageTask.SnapshotBase) obj2);
                }
            };
            OnCompleteListener onCompleteListener = new OnCompleteListener() { // from class: com.google.firebase.storage.ktx.d
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    StorageKt$taskState$1.invokeSuspend$lambda$4(sVar, task);
                }
            };
            this.$this_taskState.addOnProgressListener((OnProgressListener) onProgressListener);
            this.$this_taskState.addOnPausedListener((OnPausedListener) onPausedListener);
            this.$this_taskState.addOnCompleteListener((OnCompleteListener) onCompleteListener);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_taskState, onProgressListener, onPausedListener, onCompleteListener);
            this.label = 1;
            if (v3.q.a(sVar, anonymousClass1, this) == objE) {
                return objE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
        }
        return E.f5463a;
    }

    @Override // i3.o
    public final Object invoke(v3.s sVar, Z2.e eVar) {
        return ((StorageKt$taskState$1) create(sVar, eVar)).invokeSuspend(E.f5463a);
    }
}
