package w4;

import s3.AbstractC1024h;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: w4.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1320b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1320b0 f11182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1320b0[] f11183d;
    public static final /* synthetic */ EnumC1320b0[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.j0 f11185b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1320b0 EF0;

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:227)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:141)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:78)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:62)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:55)
        */
    static {
        /*
            w4.b0 r0 = new w4.b0
            u4.j0 r1 = u4.j0.f10443n
            java.lang.String r2 = "NO_ERROR"
            r14 = 0
            r0.<init>(r2, r14, r14, r1)
            w4.b0 r2 = new w4.b0
            u4.j0 r3 = u4.j0.f10442m
            java.lang.String r4 = "PROTOCOL_ERROR"
            r15 = 1
            r2.<init>(r4, r15, r15, r3)
            r4 = r2
            w4.b0 r2 = new w4.b0
            java.lang.String r5 = "INTERNAL_ERROR"
            r6 = 2
            r2.<init>(r5, r6, r6, r3)
            w4.EnumC1320b0.f11182c = r2
            w4.b0 r5 = new w4.b0
            java.lang.String r6 = "FLOW_CONTROL_ERROR"
            r7 = 3
            r5.<init>(r6, r7, r7, r3)
            r6 = r4
            w4.b0 r4 = new w4.b0
            java.lang.String r7 = "SETTINGS_TIMEOUT"
            r8 = 4
            r4.<init>(r7, r8, r8, r3)
            r7 = r5
            w4.b0 r5 = new w4.b0
            java.lang.String r8 = "STREAM_CLOSED"
            r9 = 5
            r5.<init>(r8, r9, r9, r3)
            r8 = r6
            w4.b0 r6 = new w4.b0
            java.lang.String r9 = "FRAME_SIZE_ERROR"
            r10 = 6
            r6.<init>(r9, r10, r10, r3)
            r9 = r7
            w4.b0 r7 = new w4.b0
            java.lang.String r10 = "REFUSED_STREAM"
            r11 = 7
            r7.<init>(r10, r11, r11, r1)
            r1 = r8
            w4.b0 r8 = new w4.b0
            u4.j0 r10 = u4.j0.f10436f
            java.lang.String r11 = "CANCEL"
            r12 = 8
            r8.<init>(r11, r12, r12, r10)
            r10 = r9
            w4.b0 r9 = new w4.b0
            java.lang.String r11 = "COMPRESSION_ERROR"
            r12 = 9
            r9.<init>(r11, r12, r12, r3)
            r11 = r10
            w4.b0 r10 = new w4.b0
            java.lang.String r12 = "CONNECT_ERROR"
            r13 = 10
            r10.<init>(r12, r13, r13, r3)
            r3 = r11
            w4.b0 r11 = new w4.b0
            u4.j0 r12 = u4.j0.f10440k
            java.lang.String r13 = "Bandwidth exhausted"
            u4.j0 r12 = r12.g(r13)
            java.lang.String r13 = "ENHANCE_YOUR_CALM"
            r14 = 11
            r11.<init>(r13, r14, r14, r12)
            w4.b0 r12 = new w4.b0
            u4.j0 r13 = u4.j0.i
            java.lang.String r14 = "Permission denied as protocol is not secure enough to call"
            u4.j0 r13 = r13.g(r14)
            java.lang.String r14 = "INADEQUATE_SECURITY"
            r16 = r15
            r15 = 12
            r12.<init>(r14, r15, r15, r13)
            w4.b0 r13 = new w4.b0
            u4.j0 r14 = u4.j0.f10437g
            java.lang.String r15 = "HTTP_1_1_REQUIRED"
            r17 = r0
            r0 = 13
            r13.<init>(r15, r0, r0, r14)
            r0 = r17
            w4.b0[] r0 = new w4.EnumC1320b0[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}
            w4.EnumC1320b0.e = r0
            w4.b0[] r0 = values()
            int r1 = r0.length
            int r1 = r1 + (-1)
            r1 = r0[r1]
            int r1 = r1.f11184a
            long r1 = (long) r1
            int r1 = (int) r1
            int r1 = r1 + 1
            w4.b0[] r1 = new w4.EnumC1320b0[r1]
            int r2 = r0.length
            r14 = 0
        Lb8:
            if (r14 >= r2) goto Lc5
            r3 = r0[r14]
            int r4 = r3.f11184a
            long r4 = (long) r4
            int r4 = (int) r4
            r1[r4] = r3
            int r14 = r14 + 1
            goto Lb8
        Lc5:
            w4.EnumC1320b0.f11183d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.EnumC1320b0.<clinit>():void");
    }

    public EnumC1320b0(String str, int i, int i6, u4.j0 j0Var) {
        this.f11184a = i6;
        String strD = "HTTP/2 error code: " + name();
        if (j0Var.f10447b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(strD);
            sb.append(" (");
            strD = AbstractC1024h.d(sb, j0Var.f10447b, ")");
        }
        this.f11185b = j0Var.g(strD);
    }

    public static EnumC1320b0 valueOf(String str) {
        return (EnumC1320b0) Enum.valueOf(EnumC1320b0.class, str);
    }

    public static EnumC1320b0[] values() {
        return (EnumC1320b0[]) e.clone();
    }
}
