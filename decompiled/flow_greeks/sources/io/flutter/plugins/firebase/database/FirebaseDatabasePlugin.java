package io.flutter.plugins.firebase.database;

import android.os.Handler;
import android.os.Looper;
import cd.r;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import e8.r;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi;
import io.flutter.plugins.firebase.database.FirebaseDatabasePlugin;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b \u0010!J)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\"\u0010!J)\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b#\u0010!J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b$\u0010!J)\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b%\u0010!J)\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b&\u0010!J)\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b'\u0010!J7\u0010(\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b(\u0010!J7\u0010)\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b)\u0010!J)\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b*\u0010!J)\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b+\u0010!J)\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b,\u0010!J)\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b-\u0010!J)\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b.\u0010!J)\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b/\u0010!J\u000f\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\fH\u0002¢\u0006\u0004\b1\u0010\u0005J\u0017\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\f2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0019\u0010:\u001a\u00020\f2\b\b\u0001\u00107\u001a\u000206H\u0016¢\u0006\u0004\b:\u00109J)\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00130\u001e2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b?\u0010@J1\u0010 \u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b \u0010DJ1\u0010\"\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b\"\u0010DJ9\u0010G\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010F\u001a\u00020E2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bG\u0010HJ9\u0010K\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010J\u001a\u00020I2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bK\u0010LJ9\u0010M\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010F\u001a\u00020E2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bM\u0010HJA\u0010P\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020I2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bP\u0010QJ;\u0010T\u001a\u00020\f2\u0006\u00103\u001a\u0002022\b\u0010R\u001a\u0004\u0018\u00010\u00062\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bT\u0010UJ9\u0010W\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010V\u001a\u00020\u00062\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bW\u0010UJ1\u0010#\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b#\u0010DJ9\u0010Z\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020X2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bZ\u0010[J9\u0010\\\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020X2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b\\\u0010[J9\u0010^\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020]2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b^\u0010_J9\u0010`\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020X2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b`\u0010[J9\u0010b\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020a2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bb\u0010cJG\u0010e\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010d\u001a\u00020I2&\u0010C\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\be\u0010LJ9\u0010f\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020X2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bf\u0010[J9\u0010g\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020X2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bg\u0010[J9\u0010h\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020]2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bh\u0010_J9\u0010i\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010R\u001a\u00020\u00062\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bi\u0010UJ9\u0010k\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020j2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\bk\u0010lJ9\u0010*\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020j2\u0018\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b*\u0010lJG\u0010)\u001a\u00020\f2\u0006\u00103\u001a\u0002022\u0006\u0010Y\u001a\u00020j2&\u0010C\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130B\u0012\u0004\u0012\u00020\f0AH\u0016¢\u0006\u0004\b)\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR \u0010s\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010xR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R \u0010}\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020a0|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R.\u0010\u007f\u001a\u001c\u0012\u0004\u0012\u00020I\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010~¨\u0006\u0081\u0001"}, d2 = {"Lio/flutter/plugins/firebase/database/FirebaseDatabasePlugin;", "Lio/flutter/plugins/firebase/core/FlutterFirebasePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;", "<init>", "()V", "", "key", "Le8/h;", "getCachedFirebaseDatabaseInstanceForKey", "(Ljava/lang/String;)Le8/h;", "database", "Lcd/h0;", "setCachedFirebaseDatabaseInstanceForKey", "(Le8/h;Ljava/lang/String;)V", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "initPluginInstance", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "", "", "arguments", "getDatabase", "(Ljava/util/Map;)Le8/h;", "Le8/e;", "getReference", "(Ljava/util/Map;)Le8/e;", "Le8/p;", "getQuery", "(Ljava/util/Map;)Le8/p;", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "goOnline", "(Ljava/util/Map;)Lcom/google/android/gms/tasks/Task;", "goOffline", "purgeOutstandingWrites", "setValue", "setValueWithPriority", "update", "setPriority", "runTransaction", "queryGet", "queryKeepSynced", "observe", "setOnDisconnect", "setWithPriorityOnDisconnect", "updateOnDisconnect", "cancelOnDisconnect", "cleanup", "removeEventStreamHandlers", "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;", "app", "getDatabaseFromPigeonApp", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;)Le8/h;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "La7/g;", "firebaseApp", "getPluginConstantsForFirebaseApp", "(La7/g;)Lcom/google/android/gms/tasks/Task;", "didReinitializeFirebaseCore", "()Lcom/google/android/gms/tasks/Task;", "Lkotlin/Function1;", "Lcd/r;", "callback", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lpd/k;)V", "", io.flutter.plugins.firebase.analytics.Constants.ENABLED, "setPersistenceEnabled", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;ZLpd/k;)V", "", "cacheSize", "setPersistenceCacheSizeBytes", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;JLpd/k;)V", "setLoggingEnabled", DiagnosticsTracker.HOST_KEY, "port", "useDatabaseEmulator", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;JLpd/k;)V", Constants.PATH, "Lio/flutter/plugins/firebase/database/DatabaseReferencePlatform;", "ref", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;Lpd/k;)V", "url", "refFromURL", "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;", "request", "databaseReferenceSet", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V", "databaseReferenceSetWithPriority", "Lio/flutter/plugins/firebase/database/UpdateRequest;", "databaseReferenceUpdate", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/UpdateRequest;Lpd/k;)V", "databaseReferenceSetPriority", "Lio/flutter/plugins/firebase/database/TransactionRequest;", "databaseReferenceRunTransaction", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/TransactionRequest;Lpd/k;)V", Constants.TRANSACTION_KEY, "databaseReferenceGetTransactionResult", "onDisconnectSet", "onDisconnectSetWithPriority", "onDisconnectUpdate", "onDisconnectCancel", "Lio/flutter/plugins/firebase/database/QueryRequest;", "queryObserve", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V", "", "listenerCount", "I", "Ljava/util/HashMap;", "Lio/flutter/plugin/common/EventChannel;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "streamHandlers", "Ljava/util/HashMap;", "Lio/flutter/plugin/common/MethodChannel;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/BinaryMessenger;", "Ljava/util/concurrent/ExecutorService;", "cachedThreadPool", "Ljava/util/concurrent/ExecutorService;", "", "transactionRequests", "Ljava/util/Map;", "transactionResults", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirebaseDatabasePlugin implements FlutterFirebasePlugin, FlutterPlugin, FirebaseDatabaseHostApi {
    private static final String METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_database";
    private final ExecutorService cachedThreadPool;
    private int listenerCount;
    private BinaryMessenger messenger;
    private MethodChannel methodChannel;
    private final HashMap<EventChannel, EventChannel.StreamHandler> streamHandlers = new HashMap<>();
    private final Map<Long, TransactionRequest> transactionRequests;
    private final Map<Long, Map<String, Object>> transactionResults;
    private static final HashMap<String, e8.h> databaseInstanceCache = new HashMap<>();

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.database.FirebaseDatabasePlugin$databaseReferenceRunTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"io/flutter/plugins/firebase/database/FirebaseDatabasePlugin$databaseReferenceRunTransaction$1", "Le8/r$b;", "Le8/m;", "mutableData", "Le8/r$c;", "doTransaction", "(Le8/m;)Le8/r$c;", "Le8/c;", "error", "", Constants.COMMITTED, "Le8/b;", "currentData", "Lcd/h0;", "onComplete", "(Le8/c;ZLe8/b;)V", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements r.b {
        final /* synthetic */ pd.k $callback;
        final /* synthetic */ TransactionRequest $request;

        public AnonymousClass1(TransactionRequest transactionRequest, pd.k kVar) {
            this.$request = transactionRequest;
            this.$callback = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void doTransaction$lambda$3(FirebaseDatabasePlugin firebaseDatabasePlugin, TransactionRequest transactionRequest, e8.m mVar, final CountDownLatch countDownLatch, final kotlin.jvm.internal.m0 m0Var) {
            BinaryMessenger binaryMessenger = firebaseDatabasePlugin.messenger;
            String str = null;
            Object[] objArr = 0;
            if (binaryMessenger == null) {
                kotlin.jvm.internal.t.s("messenger");
                binaryMessenger = null;
            }
            new FirebaseDatabaseFlutterApi(binaryMessenger, str, 2, objArr == true ? 1 : 0).callTransactionHandler(transactionRequest.getTransactionKey(), mVar.c(), new pd.k() { // from class: io.flutter.plugins.firebase.database.t1
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return FirebaseDatabasePlugin.AnonymousClass1.doTransaction$lambda$3$lambda$2(countDownLatch, m0Var, (cd.r) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 doTransaction$lambda$3$lambda$2(CountDownLatch countDownLatch, kotlin.jvm.internal.m0 m0Var, cd.r rVar) {
            Object objJ = rVar.j();
            if (cd.r.e(objJ) == null) {
                m0Var.f14947a = (TransactionHandlerResult) objJ;
            } else {
                m0Var.f14947a = new TransactionHandlerResult(null, true, true);
            }
            countDownLatch.countDown();
            return cd.h0.f3852a;
        }

        @Override // e8.r.b
        public r.c doTransaction(final e8.m mutableData) throws InterruptedException {
            kotlin.jvm.internal.t.f(mutableData, "mutableData");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
            Handler handler = new Handler(Looper.getMainLooper());
            final FirebaseDatabasePlugin firebaseDatabasePlugin = FirebaseDatabasePlugin.this;
            final TransactionRequest transactionRequest = this.$request;
            handler.post(new Runnable() { // from class: io.flutter.plugins.firebase.database.u1
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseDatabasePlugin.AnonymousClass1.doTransaction$lambda$3(firebaseDatabasePlugin, transactionRequest, mutableData, countDownLatch, m0Var);
                }
            });
            countDownLatch.await();
            TransactionHandlerResult transactionHandlerResult = (TransactionHandlerResult) m0Var.f14947a;
            if (transactionHandlerResult == null) {
                r.c cVarA = r.a();
                kotlin.jvm.internal.t.e(cVarA, "abort(...)");
                return cVarA;
            }
            if (transactionHandlerResult.getAborted() || transactionHandlerResult.getException()) {
                r.c cVarA2 = r.a();
                kotlin.jvm.internal.t.e(cVarA2, "abort(...)");
                return cVarA2;
            }
            mutableData.d(transactionHandlerResult.getValue());
            r.c cVarB = r.b(mutableData);
            kotlin.jvm.internal.t.e(cVarB, "success(...)");
            return cVarB;
        }

        @Override // e8.r.b
        public void onComplete(e8.c error, boolean committed, e8.b currentData) {
            FirebaseDatabasePlugin.this.transactionResults.put(Long.valueOf(this.$request.getTransactionKey()), dd.o0.l(cd.w.a(Constants.COMMITTED, Boolean.valueOf(committed)), cd.w.a(Constants.SNAPSHOT, dd.o0.l(cd.w.a("value", currentData != null ? currentData.h() : null), cd.w.a("key", currentData != null ? currentData.e() : null), cd.w.a("exists", currentData != null ? Boolean.valueOf(currentData.b()) : null)))));
            if (error == null) {
                pd.k kVar = this.$callback;
                r.a aVar = cd.r.f3870b;
                kVar.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
            } else {
                FlutterFirebaseDatabaseException flutterFirebaseDatabaseExceptionFromDatabaseError = FlutterFirebaseDatabaseException.INSTANCE.fromDatabaseError(error);
                pd.k kVar2 = this.$callback;
                r.a aVar2 = cd.r.f3870b;
                kVar2.invoke(cd.r.a(cd.r.b(cd.s.a(new FlutterError("firebase_database", flutterFirebaseDatabaseExceptionFromDatabaseError.getMessage(), flutterFirebaseDatabaseExceptionFromDatabaseError.getAdditionalData())))));
            }
        }
    }

    public FirebaseDatabasePlugin() {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        kotlin.jvm.internal.t.e(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        this.cachedThreadPool = executorServiceNewCachedThreadPool;
        this.transactionRequests = new LinkedHashMap();
        this.transactionResults = new LinkedHashMap();
    }

    private final Task<Void> cancelOnDisconnect(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.r1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.cancelOnDisconnect$lambda$19(this.f12904a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelOnDisconnect$lambda$19(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(firebaseDatabasePlugin.getReference(map).Z().c());
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final void cleanup() {
        removeEventStreamHandlers();
        databaseInstanceCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void databaseReferenceSet$lambda$22(kotlin.jvm.internal.k0 k0Var, pd.k kVar, Task completedTask) {
        kotlin.jvm.internal.t.f(completedTask, "completedTask");
        if (k0Var.f14943a) {
            return;
        }
        k0Var.f14943a = true;
        if (completedTask.isSuccessful()) {
            r.a aVar = cd.r.f3870b;
            kVar.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
            return;
        }
        Exception exception = completedTask.getException();
        if (exception == null) {
            exception = new Exception("Unknown error setting value");
        }
        r.a aVar2 = cd.r.f3870b;
        kVar.invoke(cd.r.a(cd.r.b(cd.s.a(new FlutterError("firebase_database", exception.getMessage(), null)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void databaseReferenceSetPriority$lambda$25(kotlin.jvm.internal.k0 k0Var, pd.k kVar, Task completedTask) {
        kotlin.jvm.internal.t.f(completedTask, "completedTask");
        if (k0Var.f14943a) {
            return;
        }
        k0Var.f14943a = true;
        if (completedTask.isSuccessful()) {
            r.a aVar = cd.r.f3870b;
            kVar.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
            return;
        }
        Exception exception = completedTask.getException();
        if (exception == null) {
            exception = new Exception("Unknown error setting priority");
        }
        System.out.println((Object) ("Firebase Database setPriority error: " + exception.getMessage()));
        r.a aVar2 = cd.r.f3870b;
        kVar.invoke(cd.r.a(cd.r.b(cd.s.a(exception))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void databaseReferenceSetPriority$lambda$26(kotlin.jvm.internal.k0 k0Var, Task task, pd.k kVar) {
        if (k0Var.f14943a || task.isComplete()) {
            return;
        }
        k0Var.f14943a = true;
        System.out.println((Object) "Firebase Database setPriority timeout - calling callback anyway");
        r.a aVar = cd.r.f3870b;
        kVar.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void databaseReferenceSetWithPriority$lambda$23(kotlin.jvm.internal.k0 k0Var, pd.k kVar, Task completedTask) {
        kotlin.jvm.internal.t.f(completedTask, "completedTask");
        if (k0Var.f14943a) {
            return;
        }
        k0Var.f14943a = true;
        if (completedTask.isSuccessful()) {
            r.a aVar = cd.r.f3870b;
            kVar.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
            return;
        }
        Exception exception = completedTask.getException();
        if (exception == null) {
            exception = new Exception("Unknown error setting value with priority");
        }
        r.a aVar2 = cd.r.f3870b;
        kVar.invoke(cd.r.a(cd.r.b(cd.s.a(new FlutterError("firebase_database", exception.getMessage(), null)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void databaseReferenceUpdate$lambda$24(pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (task.isSuccessful()) {
            r.a aVar = cd.r.f3870b;
            kVar.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } else {
            Exception exception = task.getException();
            r.a aVar2 = cd.r.f3870b;
            kVar.invoke(cd.r.a(cd.r.b(cd.s.a(new FlutterError("firebase_database", exception != null ? exception.getMessage() : null, null)))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void didReinitializeFirebaseCore$lambda$21(FirebaseDatabasePlugin firebaseDatabasePlugin, TaskCompletionSource taskCompletionSource) {
        try {
            firebaseDatabasePlugin.cleanup();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final e8.h getCachedFirebaseDatabaseInstanceForKey(String key) {
        e8.h hVar;
        HashMap<String, e8.h> map = databaseInstanceCache;
        synchronized (map) {
            hVar = map.get(key);
        }
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[Catch: d -> 0x007a, TryCatch #0 {d -> 0x007a, blocks: (B:17:0x0071, B:19:0x0077, B:23:0x007e, B:22:0x007c, B:26:0x0085, B:28:0x008e, B:30:0x0097, B:32:0x009b, B:33:0x00a5, B:35:0x00a9), top: B:45:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097 A[Catch: d -> 0x007a, TryCatch #0 {d -> 0x007a, blocks: (B:17:0x0071, B:19:0x0077, B:23:0x007e, B:22:0x007c, B:26:0x0085, B:28:0x008e, B:30:0x0097, B:32:0x009b, B:33:0x00a5, B:35:0x00a9), top: B:45:0x0071 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final e8.h getDatabase(java.util.Map<java.lang.String, ? extends java.lang.Object> r8) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.database.FirebaseDatabasePlugin.getDatabase(java.util.Map):e8.h");
    }

    private final e8.h getDatabaseFromPigeonApp(DatabasePigeonFirebaseApp app) {
        a7.g gVarP = a7.g.p(app.getAppName());
        kotlin.jvm.internal.t.e(gVarP, "getInstance(...)");
        e8.h hVarE = app.getDatabaseURL() != null ? e8.h.e(gVarP, app.getDatabaseURL()) : e8.h.d(gVarP);
        kotlin.jvm.internal.t.c(hVarE);
        try {
            Boolean loggingEnabled = app.getSettings().getLoggingEnabled();
            if (loggingEnabled != null) {
                hVarE.m(loggingEnabled.booleanValue() ? e8.l.DEBUG : e8.l.NONE);
            }
            String emulatorHost = app.getSettings().getEmulatorHost();
            Long emulatorPort = app.getSettings().getEmulatorPort();
            if (emulatorHost != null && emulatorPort != null) {
                hVarE.p(emulatorHost, (int) emulatorPort.longValue());
            }
            Boolean persistenceEnabled = app.getSettings().getPersistenceEnabled();
            if (persistenceEnabled != null) {
                hVarE.o(persistenceEnabled.booleanValue());
            }
            Long cacheSizeBytes = app.getSettings().getCacheSizeBytes();
            if (cacheSizeBytes != null) {
                hVarE.n(cacheSizeBytes.longValue());
            }
        } catch (e8.d unused) {
        }
        return hVarE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPluginConstantsForFirebaseApp$lambda$20(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final e8.p getQuery(Map<String, ? extends Object> arguments) {
        e8.e reference = getReference(arguments);
        Object obj = arguments.get(Constants.MODIFIERS);
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        return new QueryBuilder(reference, (List) obj).build();
    }

    private final e8.e getReference(Map<String, ? extends Object> arguments) {
        e8.h database = getDatabase(arguments);
        Object obj = arguments.get(Constants.PATH);
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
        e8.e eVarG = database.g((String) obj);
        kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
        return eVarG;
    }

    private final Task<Void> goOffline(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.d1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.goOffline$lambda$6(this.f12840a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goOffline$lambda$6(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            firebaseDatabasePlugin.getDatabase(map).j();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> goOnline(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.p1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.goOnline$lambda$5(this.f12896a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goOnline$lambda$5(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            firebaseDatabasePlugin.getDatabase(map).k();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final void initPluginInstance(BinaryMessenger messenger) {
        FlutterFirebasePluginRegistry.registerPlugin(METHOD_CHANNEL_NAME, this);
        this.messenger = messenger;
        this.methodChannel = new MethodChannel(messenger, METHOD_CHANNEL_NAME);
        FirebaseDatabaseHostApi.Companion.setUp$default(FirebaseDatabaseHostApi.INSTANCE, messenger, this, null, 4, null);
    }

    private final Task<String> observe(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.c1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.observe$lambda$15(this.f12835a, arguments, taskCompletionSource);
            }
        });
        Task<String> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe$lambda$15(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e8.p query = firebaseDatabasePlugin.getQuery(map);
            Object obj = map.get(Constants.EVENT_CHANNEL_NAME_PREFIX);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            int i10 = firebaseDatabasePlugin.listenerCount;
            firebaseDatabasePlugin.listenerCount = i10 + 1;
            String str = ((String) obj) + "#" + i10;
            BinaryMessenger binaryMessenger = firebaseDatabasePlugin.messenger;
            if (binaryMessenger == null) {
                kotlin.jvm.internal.t.s("messenger");
                binaryMessenger = null;
            }
            final EventChannel eventChannel = new EventChannel(binaryMessenger, str);
            EventStreamHandler eventStreamHandler = new EventStreamHandler(query, new OnDispose() { // from class: io.flutter.plugins.firebase.database.FirebaseDatabasePlugin$observe$1$streamHandler$1
                @Override // io.flutter.plugins.firebase.database.OnDispose
                public void run() {
                    eventChannel.setStreamHandler(null);
                }
            });
            eventChannel.setStreamHandler(eventStreamHandler);
            firebaseDatabasePlugin.streamHandlers.put(eventChannel, eventStreamHandler);
            taskCompletionSource.setResult(str);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> purgeOutstandingWrites(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.h1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.purgeOutstandingWrites$lambda$7(this.f12859a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void purgeOutstandingWrites$lambda$7(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            firebaseDatabasePlugin.getDatabase(map).l();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Map<String, Object>> queryGet(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.j1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.queryGet$lambda$13(this.f12868a, arguments, taskCompletionSource);
            }
        });
        Task<Map<String, Object>> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryGet$lambda$13(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e8.b bVar = (e8.b) Tasks.await(firebaseDatabasePlugin.getQuery(map).r());
            kotlin.jvm.internal.t.c(bVar);
            taskCompletionSource.setResult(new FlutterDataSnapshotPayload(bVar).toMap());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryGet$lambda$27(pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (task.isSuccessful()) {
            e8.b bVar = (e8.b) task.getResult();
            kotlin.jvm.internal.t.c(bVar);
            FlutterDataSnapshotPayload flutterDataSnapshotPayload = new FlutterDataSnapshotPayload(bVar);
            r.a aVar = cd.r.f3870b;
            kVar.invoke(cd.r.a(cd.r.b(flutterDataSnapshotPayload.toMap())));
            return;
        }
        r.a aVar2 = cd.r.f3870b;
        Exception exception = task.getException();
        if (exception == null) {
            exception = new Exception("Unknown error");
        }
        kVar.invoke(cd.r.a(cd.r.b(cd.s.a(exception))));
    }

    private final Task<Void> queryKeepSynced(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.y0
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.queryKeepSynced$lambda$14(this.f12932a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryKeepSynced$lambda$14(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e8.p query = firebaseDatabasePlugin.getQuery(map);
            Object obj = map.get("value");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            query.v(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final void removeEventStreamHandlers() {
        for (Map.Entry<EventChannel, EventChannel.StreamHandler> entry : this.streamHandlers.entrySet()) {
            EventChannel key = entry.getKey();
            EventChannel.StreamHandler value = entry.getValue();
            if (value != null) {
                value.onCancel(null);
            }
            key.setStreamHandler(null);
        }
        this.streamHandlers.clear();
    }

    private final Task<Map<String, Object>> runTransaction(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.m1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.runTransaction$lambda$12(this.f12883a, arguments, taskCompletionSource);
            }
        });
        Task<Map<String, Object>> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTransaction$lambda$12(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e8.e reference = firebaseDatabasePlugin.getReference(map);
            Object obj = map.get(Constants.TRANSACTION_KEY);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = map.get(Constants.TRANSACTION_APPLY_LOCALLY);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            MethodChannel methodChannel = firebaseDatabasePlugin.methodChannel;
            if (methodChannel == null) {
                kotlin.jvm.internal.t.s("methodChannel");
                methodChannel = null;
            }
            TransactionHandler transactionHandler = new TransactionHandler(methodChannel, iIntValue);
            reference.b0(transactionHandler, zBooleanValue);
            taskCompletionSource.setResult((Map) Tasks.await(transactionHandler.getTask()));
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final void setCachedFirebaseDatabaseInstanceForKey(e8.h database, String key) {
        HashMap<String, e8.h> map = databaseInstanceCache;
        synchronized (map) {
            try {
                if (map.get(key) == null) {
                    map.put(key, database);
                }
                cd.h0 h0Var = cd.h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final Task<Void> setOnDisconnect(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.q1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.setOnDisconnect$lambda$16(arguments, this, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnDisconnect$lambda$16(Map map, FirebaseDatabasePlugin firebaseDatabasePlugin, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get("value");
            e8.n nVarZ = firebaseDatabasePlugin.getReference(map).Z();
            kotlin.jvm.internal.t.e(nVarZ, "onDisconnect(...)");
            Tasks.await(nVarZ.f(obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> setPriority(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.f1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.setPriority$lambda$11(this.f12850a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPriority$lambda$11(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(firebaseDatabasePlugin.getReference(map).c0(map.get(Constants.PRIORITY)));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> setValue(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.e1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.setValue$lambda$8(this.f12845a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setValue$lambda$8(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(firebaseDatabasePlugin.getReference(map).e0(map.get("value")));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> setValueWithPriority(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.n1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.setValueWithPriority$lambda$9(this.f12888a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setValueWithPriority$lambda$9(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(firebaseDatabasePlugin.getReference(map).f0(map.get("value"), map.get(Constants.PRIORITY)));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> setWithPriorityOnDisconnect(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.l1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.setWithPriorityOnDisconnect$lambda$17(arguments, this, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWithPriorityOnDisconnect$lambda$17(Map map, FirebaseDatabasePlugin firebaseDatabasePlugin, TaskCompletionSource taskCompletionSource) {
        Task taskH;
        try {
            Object obj = map.get("value");
            Object obj2 = map.get(Constants.PRIORITY);
            e8.n nVarZ = firebaseDatabasePlugin.getReference(map).Z();
            kotlin.jvm.internal.t.e(nVarZ, "onDisconnect(...)");
            if (obj2 instanceof Double) {
                taskH = nVarZ.g(obj, ((Number) obj2).doubleValue());
            } else if (obj2 instanceof String) {
                taskH = nVarZ.h(obj, (String) obj2);
            } else {
                if (obj2 != null) {
                    throw new Exception("Invalid priority value for OnDisconnect.setWithPriority");
                }
                taskH = nVarZ.h(obj, null);
            }
            kotlin.jvm.internal.t.c(taskH);
            Tasks.await(taskH);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> update(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.k1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.update$lambda$10(this.f12873a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$10(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e8.e reference = firebaseDatabasePlugin.getReference(map);
            Object obj = map.get("value");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            Tasks.await(reference.h0((Map) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> updateOnDisconnect(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.w0
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.updateOnDisconnect$lambda$18(this.f12926a, arguments, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateOnDisconnect$lambda$18(FirebaseDatabasePlugin firebaseDatabasePlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e8.e reference = firebaseDatabasePlugin.getReference(map);
            Object obj = map.get("value");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            Task taskI = reference.Z().i((Map) obj);
            kotlin.jvm.internal.t.e(taskI, "updateChildren(...)");
            Tasks.await(taskI);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void databaseReferenceGetTransactionResult(DatabasePigeonFirebaseApp app, long transactionKey, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            Map<String, Object> map = this.transactionResults.get(Long.valueOf(transactionKey));
            if (map != null) {
                callback.invoke(cd.r.a(cd.r.b(map)));
            } else {
                callback.invoke(cd.r.a(cd.r.b(dd.o0.l(cd.w.a(Constants.COMMITTED, Boolean.FALSE), cd.w.a(Constants.SNAPSHOT, dd.n0.e(cd.w.a("value", null)))))));
            }
        } catch (Exception e10) {
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void databaseReferenceRunTransaction(DatabasePigeonFirebaseApp app, TransactionRequest request, pd.k callback) {
        FlutterFirebaseDatabaseException flutterFirebaseDatabaseExceptionUnknown;
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            this.transactionRequests.put(Long.valueOf(request.getTransactionKey()), request);
            eVarG.a0(new AnonymousClass1(request, callback));
        } catch (Exception e10) {
            if (e10 instanceof FlutterFirebaseDatabaseException) {
                flutterFirebaseDatabaseExceptionUnknown = (FlutterFirebaseDatabaseException) e10;
            } else {
                FlutterFirebaseDatabaseException.Companion companion = FlutterFirebaseDatabaseException.INSTANCE;
                String message = e10.getMessage();
                if (message == null) {
                    message = "Unknown transaction error";
                }
                flutterFirebaseDatabaseExceptionUnknown = companion.unknown(message);
            }
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(new FlutterError("firebase_database", flutterFirebaseDatabaseExceptionUnknown.getMessage(), flutterFirebaseDatabaseExceptionUnknown.getAdditionalData())))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void databaseReferenceSet(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, final pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            Task taskE0 = eVarG.e0(request.getValue());
            kotlin.jvm.internal.t.e(taskE0, "setValue(...)");
            final kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
            kotlin.jvm.internal.t.c(taskE0.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.database.i1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FirebaseDatabasePlugin.databaseReferenceSet$lambda$22(k0Var, callback, task);
                }
            }));
        } catch (Exception e10) {
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void databaseReferenceSetPriority(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, final pd.k callback) {
        Object string;
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            Object priority = request.getPriority();
            if ((priority instanceof String) || (priority instanceof Number)) {
                string = (Serializable) request.getPriority();
            } else {
                if (priority == null) {
                    string = null;
                } else {
                    Object priority2 = request.getPriority();
                    System.out.println((Object) ("Warning: Unexpected priority type: " + (priority2 != null ? priority2.getClass().getSimpleName() : null) + ", value: " + request + ".priority"));
                    string = request.getPriority().toString();
                }
            }
            final Task taskC0 = eVarG.c0(string);
            kotlin.jvm.internal.t.e(taskC0, "setPriority(...)");
            final kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
            taskC0.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.database.a1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FirebaseDatabasePlugin.databaseReferenceSetPriority$lambda$25(k0Var, callback, task);
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: io.flutter.plugins.firebase.database.b1
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseDatabasePlugin.databaseReferenceSetPriority$lambda$26(k0Var, taskC0, callback);
                }
            }, 3000L);
        } catch (Exception e10) {
            System.out.println((Object) ("Firebase Database setPriority error: " + e10.getMessage()));
            e10.printStackTrace();
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void databaseReferenceSetWithPriority(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, final pd.k callback) {
        Object string;
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            Object priority = request.getPriority();
            if ((priority instanceof String) || (priority instanceof Number)) {
                string = (Serializable) request.getPriority();
            } else {
                if (priority == null) {
                    string = null;
                } else {
                    Object priority2 = request.getPriority();
                    System.out.println((Object) ("Warning: Unexpected priority type: " + (priority2 != null ? priority2.getClass().getSimpleName() : null) + ", value: " + request + ".priority"));
                    string = request.getPriority().toString();
                }
            }
            Task taskF0 = eVarG.f0(request.getValue(), string);
            kotlin.jvm.internal.t.e(taskF0, "setValue(...)");
            final kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
            kotlin.jvm.internal.t.c(taskF0.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.database.z0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FirebaseDatabasePlugin.databaseReferenceSetWithPriority$lambda$23(k0Var, callback, task);
                }
            }));
        } catch (Exception e10) {
            System.out.println((Object) ("Firebase Database setWithPriority error: " + e10.getMessage()));
            e10.printStackTrace();
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void databaseReferenceUpdate(DatabasePigeonFirebaseApp app, UpdateRequest request, final pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
        kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
        eVarG.h0(request.getValue()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.database.x0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseDatabasePlugin.databaseReferenceUpdate$lambda$24(callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.g1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.didReinitializeFirebaseCore$lambda$21(this.f12855a, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(a7.g firebaseApp) {
        kotlin.jvm.internal.t.f(firebaseApp, "firebaseApp");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.database.s1
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseDatabasePlugin.getPluginConstantsForFirebaseApp$lambda$20(taskCompletionSource);
            }
        });
        Task<Map<String, Object>> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.t.e(binaryMessenger, "getBinaryMessenger(...)");
        initPluginInstance(binaryMessenger);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        MethodChannel methodChannel = this.methodChannel;
        if (methodChannel == null) {
            kotlin.jvm.internal.t.s("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
        cleanup();
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void onDisconnectCancel(DatabasePigeonFirebaseApp app, String path, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(path, "path");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(path);
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            e8.n nVarZ = eVarG.Z();
            kotlin.jvm.internal.t.e(nVarZ, "onDisconnect(...)");
            nVarZ.c();
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void onDisconnectSet(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            e8.n nVarZ = eVarG.Z();
            kotlin.jvm.internal.t.e(nVarZ, "onDisconnect(...)");
            nVarZ.f(request.getValue());
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void onDisconnectSetWithPriority(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            e8.n nVarZ = eVarG.Z();
            kotlin.jvm.internal.t.e(nVarZ, "onDisconnect(...)");
            Object value = request.getValue();
            Object priority = request.getPriority();
            nVarZ.h(value, priority instanceof String ? (String) priority : null);
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void onDisconnectUpdate(DatabasePigeonFirebaseApp app, UpdateRequest request, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            e8.n nVarZ = eVarG.Z();
            kotlin.jvm.internal.t.e(nVarZ, "onDisconnect(...)");
            nVarZ.i(request.getValue());
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x0048, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void queryObserve(io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp r11, io.flutter.plugins.firebase.database.QueryRequest r12, pd.k r13) {
        /*
            Method dump skipped, instruction units count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.database.FirebaseDatabasePlugin.queryObserve(io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp, io.flutter.plugins.firebase.database.QueryRequest, pd.k):void");
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void ref(DatabasePigeonFirebaseApp app, String path, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.h databaseFromPigeonApp = getDatabaseFromPigeonApp(app);
            e8.e eVarF = (path == null || path.length() == 0) ? databaseFromPigeonApp.f() : databaseFromPigeonApp.g(path);
            kotlin.jvm.internal.t.c(eVarF);
            String strX = eVarF.X();
            if (strX == null) {
                strX = "/";
            }
            callback.invoke(cd.r.a(cd.r.b(new DatabaseReferencePlatform(strX))));
        } catch (Exception e10) {
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void refFromURL(DatabasePigeonFirebaseApp app, String url, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(url, "url");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarH = getDatabaseFromPigeonApp(app).h(url);
            kotlin.jvm.internal.t.e(eVarH, "getReferenceFromUrl(...)");
            String strX = eVarH.X();
            if (strX == null) {
                strX = "/";
            }
            callback.invoke(cd.r.a(cd.r.b(new DatabaseReferencePlatform(strX))));
        } catch (Exception e10) {
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void setLoggingEnabled(DatabasePigeonFirebaseApp app, boolean enabled, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).m(enabled ? e8.l.DEBUG : e8.l.NONE);
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void setPersistenceCacheSizeBytes(DatabasePigeonFirebaseApp app, long cacheSize, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).n(cacheSize);
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void setPersistenceEnabled(DatabasePigeonFirebaseApp app, boolean enabled, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).o(enabled);
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void useDatabaseEmulator(DatabasePigeonFirebaseApp app, String host, long port, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(host, "host");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).p(host, (int) port);
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void goOffline(DatabasePigeonFirebaseApp app, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).j();
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void goOnline(DatabasePigeonFirebaseApp app, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).k();
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void purgeOutstandingWrites(DatabasePigeonFirebaseApp app, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            getDatabaseFromPigeonApp(app).l();
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:224:0x002d, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void queryGet(io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp r11, io.flutter.plugins.firebase.database.QueryRequest r12, final pd.k r13) {
        /*
            Method dump skipped, instruction units count: 926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.database.FirebaseDatabasePlugin.queryGet(io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp, io.flutter.plugins.firebase.database.QueryRequest, pd.k):void");
    }

    @Override // io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi
    public void queryKeepSynced(DatabasePigeonFirebaseApp app, QueryRequest request, pd.k callback) {
        kotlin.jvm.internal.t.f(app, "app");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(callback, "callback");
        try {
            e8.e eVarG = getDatabaseFromPigeonApp(app).g(request.getPath());
            kotlin.jvm.internal.t.e(eVarG, "getReference(...)");
            Boolean value = request.getValue();
            eVarG.v(value != null ? value.booleanValue() : false);
            r.a aVar = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.h0.f3852a)));
        } catch (Exception e10) {
            r.a aVar2 = cd.r.f3870b;
            callback.invoke(cd.r.a(cd.r.b(cd.s.a(e10))));
        }
    }
}
