package dd;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.k implements pd.o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f8029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f8030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f8031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8034g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8035h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public /* synthetic */ Object f8036i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f8037j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f8038k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Iterator f8039l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f8040m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f8041n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10, int i11, Iterator it, boolean z10, boolean z11, gd.e eVar) {
            super(2, eVar);
            this.f8037j = i10;
            this.f8038k = i11;
            this.f8039l = it;
            this.f8040m = z10;
            this.f8041n = z11;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(jg.j jVar, gd.e eVar) {
            return ((a) create(jVar, eVar)).invokeSuspend(cd.h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(this.f8037j, this.f8038k, this.f8039l, this.f8040m, this.f8041n, eVar);
            aVar.f8036i = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x00c7 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b1 -> B:17:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0143 -> B:60:0x0146). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0177 -> B:73:0x017a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 422
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: dd.w0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i10, int i11) {
        String str;
        if (i10 <= 0 || i11 <= 0) {
            if (i10 != i11) {
                str = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
            } else {
                str = "size " + i10 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final Iterator b(Iterator iterator, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.f(iterator, "iterator");
        return !iterator.hasNext() ? b0.f7990a : jg.k.a(new a(i10, i11, iterator, z11, z10, null));
    }
}
