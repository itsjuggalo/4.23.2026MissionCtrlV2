package u4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import x4.C1412h;

/* JADX INFO: loaded from: classes.dex */
public final class T {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f10363c = Logger.getLogger(T.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static T f10364d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f10365a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10366b = Collections.EMPTY_LIST;

    public static List a() {
        Logger logger = f10363c;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(C1412h.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e2);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e6) {
            logger.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e6);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
