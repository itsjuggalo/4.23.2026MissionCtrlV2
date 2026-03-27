package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.storage.H;
import e4.AbstractC1482d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class p implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1220f f12483b;

    public class a implements OnFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f12484a;

        public a(TaskCompletionSource taskCompletionSource) {
            this.f12484a = taskCompletionSource;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.f12484a.setException(C1228n.e(exc, 0));
        }
    }

    public class b implements OnSuccessListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f12486a;

        public b(TaskCompletionSource taskCompletionSource) {
            this.f12486a = taskCompletionSource;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(H.d dVar) {
            if (this.f12486a.getTask().isComplete()) {
                return;
            }
            Log.e("StorageReference", "getBytes 'succeeded', but failed to set a Result.");
            this.f12486a.setException(C1228n.c(Status.f10840h));
        }
    }

    public class c implements H.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f12488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f12489b;

        public c(long j7, TaskCompletionSource taskCompletionSource) {
            this.f12488a = j7;
            this.f12489b = taskCompletionSource;
        }

        @Override // com.google.firebase.storage.H.b
        public void a(H.d dVar, InputStream inputStream) throws IOException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[16384];
                int i7 = 0;
                while (true) {
                    int i8 = inputStream.read(bArr, 0, 16384);
                    if (i8 == -1) {
                        byteArrayOutputStream.flush();
                        this.f12489b.setResult(byteArrayOutputStream.toByteArray());
                        inputStream.close();
                        return;
                    } else {
                        i7 += i8;
                        if (i7 > this.f12488a) {
                            Log.e("StorageReference", "the maximum allowed buffer size was exceeded.");
                            throw new IndexOutOfBoundsException("the maximum allowed buffer size was exceeded.");
                        }
                        byteArrayOutputStream.write(bArr, 0, i8);
                    }
                }
            } catch (Throwable th) {
                inputStream.close();
                throw th;
            }
        }
    }

    public class d implements Continuation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f12491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f12492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Executor f12493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f12494d;

        public d(List list, List list2, Executor executor, TaskCompletionSource taskCompletionSource) {
            this.f12491a = list;
            this.f12492b = list2;
            this.f12493c = executor;
            this.f12494d = taskCompletionSource;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task then(Task task) {
            if (task.isSuccessful()) {
                C1224j c1224j = (C1224j) task.getResult();
                this.f12491a.addAll(c1224j.d());
                this.f12492b.addAll(c1224j.b());
                if (c1224j.c() != null) {
                    p.this.x(null, c1224j.c()).continueWithTask(this.f12493c, this);
                } else {
                    this.f12494d.setResult(new C1224j(this.f12491a, this.f12492b, null));
                }
            } else {
                this.f12494d.setException(task.getException());
            }
            return Tasks.forResult(null);
        }
    }

    public p(Uri uri, C1220f c1220f) {
        AbstractC1207s.b(uri != null, "storageUri cannot be null");
        AbstractC1207s.b(c1220f != null, "FirebaseApp cannot be null");
        this.f12482a = uri;
        this.f12483b = c1220f;
    }

    public N A(Uri uri) {
        AbstractC1207s.b(uri != null, "uri cannot be null");
        N n7 = new N(this, null, uri, null);
        n7.b0();
        return n7;
    }

    public N B(Uri uri, o oVar) {
        AbstractC1207s.b(uri != null, "uri cannot be null");
        AbstractC1207s.b(oVar != null, "metadata cannot be null");
        N n7 = new N(this, oVar, uri, null);
        n7.b0();
        return n7;
    }

    public Task C(o oVar) {
        AbstractC1207s.k(oVar);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        G.b().f(new M(this, taskCompletionSource, oVar));
        return taskCompletionSource.getTask();
    }

    public p b(String str) {
        AbstractC1207s.b(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        return new p(this.f12482a.buildUpon().appendEncodedPath(AbstractC1482d.b(AbstractC1482d.a(str))).build(), this.f12483b);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return this.f12482a.compareTo(pVar.f12482a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return ((p) obj).toString().equals(toString());
        }
        return false;
    }

    public Task h() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        G.b().f(new RunnableC1218d(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public Q2.g i() {
        return s().a();
    }

    public String j() {
        return this.f12482a.getAuthority();
    }

    public Task k(long j7) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        H h7 = new H(this);
        h7.r0(new c(j7, taskCompletionSource)).addOnSuccessListener(new b(taskCompletionSource)).addOnFailureListener(new a(taskCompletionSource));
        h7.b0();
        return taskCompletionSource.getTask();
    }

    public Task l() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        G.b().f(new RunnableC1222h(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public C1219e m(Uri uri) {
        C1219e c1219e = new C1219e(this, uri);
        c1219e.b0();
        return c1219e;
    }

    public Task n() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        G.b().f(new RunnableC1223i(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public String o() {
        String path = this.f12482a.getPath();
        int iLastIndexOf = path.lastIndexOf(47);
        return iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1) : path;
    }

    public p p() {
        String path = this.f12482a.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        if (path.equals("/")) {
            return null;
        }
        int iLastIndexOf = path.lastIndexOf(47);
        return new p(this.f12482a.buildUpon().path(iLastIndexOf != -1 ? path.substring(0, iLastIndexOf) : "/").build(), this.f12483b);
    }

    public String q() {
        return this.f12482a.getPath();
    }

    public p r() {
        return new p(this.f12482a.buildUpon().path("").build(), this.f12483b);
    }

    public C1220f s() {
        return this.f12483b;
    }

    public e4.h t() {
        return new e4.h(this.f12482a, this.f12483b.e());
    }

    public String toString() {
        return "gs://" + this.f12482a.getAuthority() + this.f12482a.getEncodedPath();
    }

    public Task u(int i7) {
        AbstractC1207s.b(i7 > 0, "maxResults must be greater than zero");
        AbstractC1207s.b(i7 <= 1000, "maxResults must be at most 1000");
        return x(Integer.valueOf(i7), null);
    }

    public Task v(int i7, String str) {
        AbstractC1207s.b(i7 > 0, "maxResults must be greater than zero");
        AbstractC1207s.b(i7 <= 1000, "maxResults must be at most 1000");
        AbstractC1207s.b(str != null, "pageToken must be non-null to resume a previous list() operation");
        return x(Integer.valueOf(i7), str);
    }

    public Task w() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Executor executorA = G.b().a();
        x(null, null).continueWithTask(executorA, new d(arrayList, arrayList2, executorA, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task x(Integer num, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        G.b().f(new RunnableC1225k(this, num, str, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public N y(byte[] bArr) {
        AbstractC1207s.b(bArr != null, "bytes cannot be null");
        N n7 = new N(this, null, bArr);
        n7.b0();
        return n7;
    }

    public N z(byte[] bArr, o oVar) {
        AbstractC1207s.b(bArr != null, "bytes cannot be null");
        AbstractC1207s.b(oVar != null, "metadata cannot be null");
        N n7 = new N(this, oVar, bArr);
        n7.b0();
        return n7;
    }
}
