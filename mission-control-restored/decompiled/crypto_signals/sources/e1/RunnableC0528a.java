package e1;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import io.flutter.plugins.firebase.crashlytics.FirebaseCrashlyticsTestCrash;

/* JADX INFO: renamed from: e1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0528a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6042a;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6042a) {
            case 0:
                int i = AlarmManagerSchedulerBroadcastReceiver.f4993a;
                return;
            default:
                throw new FirebaseCrashlyticsTestCrash();
        }
    }
}
