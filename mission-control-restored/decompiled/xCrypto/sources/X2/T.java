package X2;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class T {

    public static final class a extends b3.k implements i3.o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f5592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f5593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5595e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f5596f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f5597g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f5598h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Iterator f5599i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f5600j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f5601k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i4, int i5, Iterator it, boolean z4, boolean z5, Z2.e eVar) {
            super(2, eVar);
            this.f5597g = i4;
            this.f5598h = i5;
            this.f5599i = it;
            this.f5600j = z4;
            this.f5601k = z5;
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(q3.g gVar, Z2.e eVar) {
            return ((a) create(gVar, eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(this.f5597g, this.f5598h, this.f5599i, this.f5600j, this.f5601k, eVar);
            aVar.f5596f = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00b8 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0055). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0119 -> B:59:0x011c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0147 -> B:72:0x014a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: X2.T.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i4, int i5) {
        String str;
        if (i4 <= 0 || i5 <= 0) {
            if (i4 != i5) {
                str = "Both size " + i4 + " and step " + i5 + " must be greater than zero.";
            } else {
                str = "size " + i4 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final Iterator b(Iterator iterator, int i4, int i5, boolean z4, boolean z5) {
        kotlin.jvm.internal.r.f(iterator, "iterator");
        return !iterator.hasNext() ? y.f5621a : q3.h.a(new a(i4, i5, iterator, z5, z4, null));
    }
}
