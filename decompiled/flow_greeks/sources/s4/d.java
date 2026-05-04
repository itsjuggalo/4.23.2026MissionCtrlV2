package s4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import io.flutter.plugins.firebase.database.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t4.d f19974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f19975c;

    public d(Context context, t4.d dVar, f fVar) {
        this.f19973a = context;
        this.f19974b = dVar;
        this.f19975c = fVar;
    }

    @Override // s4.x
    public void a(l4.p pVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f19973a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f19973a.getSystemService("jobscheduler");
        int iC = c(pVar);
        if (!z10 && d(jobScheduler, iC, i10)) {
            p4.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jW = this.f19974b.w(pVar);
        JobInfo.Builder builderC = this.f19975c.c(new JobInfo.Builder(iC, componentName), pVar.d(), jW, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt(Constants.PRIORITY, w4.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        p4.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(iC), Long.valueOf(this.f19975c.g(pVar.d(), jW, i10)), Long.valueOf(jW), Integer.valueOf(i10));
        jobScheduler.schedule(builderC.build());
    }

    @Override // s4.x
    public void b(l4.p pVar, int i10) {
        a(pVar, i10, false);
    }

    public int c(l4.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f19973a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(w4.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i10, int i11) {
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i12 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i10) {
                if (i12 >= i11) {
                    return true;
                }
            }
        }
        return false;
    }
}
