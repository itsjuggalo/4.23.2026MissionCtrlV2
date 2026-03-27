package e1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import f1.C0592h;
import f1.InterfaceC0588d;
import i1.AbstractC0646a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0588d f6049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0529b f6050c;

    public d(Context context, InterfaceC0588d interfaceC0588d, C0529b c0529b) {
        this.f6048a = context;
        this.f6049b = interfaceC0588d;
        this.f6050c = c0529b;
    }

    public final void a(Y0.j jVar, int i, boolean z6) {
        Context context = this.f6048a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(jVar.f3565a.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        V0.d dVar = jVar.f3567c;
        adler32.update(byteBufferAllocate.putInt(AbstractC0646a.a(dVar)).array());
        byte[] bArr = jVar.f3566b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z6) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i6 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i6 >= i) {
                        D1.b.l(jVar, "JobInfoScheduler", "Upload for context %s is already scheduled. Returning...");
                        return;
                    }
                }
            }
        }
        SQLiteDatabase sQLiteDatabaseD = ((C0592h) this.f6049b).d();
        String strValueOf = String.valueOf(AbstractC0646a.a(dVar));
        String str = jVar.f3565a;
        Cursor cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, strValueOf});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            C0529b c0529b = this.f6050c;
            builder.setMinimumLatency(c0529b.a(dVar, jLongValue, i));
            Set set = ((C0530c) c0529b.f6044b.get(dVar)).f6047c;
            if (set.contains(e.f6051a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(e.f6053c)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(e.f6052b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", AbstractC0646a.a(dVar));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {jVar, Integer.valueOf(value), Long.valueOf(c0529b.a(dVar, jLongValue, i)), lValueOf, Integer.valueOf(i)};
            String strU = D1.b.u("JobInfoScheduler");
            if (Log.isLoggable(strU, 3)) {
                Log.d(strU, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }
}
