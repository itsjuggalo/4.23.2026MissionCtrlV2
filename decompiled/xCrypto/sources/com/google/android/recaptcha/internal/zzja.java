package com.google.android.recaptcha.internal;

import W2.E;
import W2.j;
import W2.k;
import X2.x;
import Z2.e;
import a3.AbstractC0787c;
import android.app.Application;
import android.webkit.WebView;
import b3.AbstractC0864b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;
import t3.AbstractC1818i;
import t3.InterfaceC1847x;
import t3.V0;

/* JADX INFO: loaded from: classes.dex */
public final class zzja extends zze {
    public InterfaceC1847x zza;
    public zzfo zzb;
    private final zzek zzc;
    private zzsc zzf;
    private final zzek zzj;
    private final j zzk;
    private final j zzl;
    private final j zzm;
    private final j zzn;
    private final j zzo;
    private zzen zzp;
    private final zzbi zzq;
    private final Map zzd = zzjb.zza();
    private final Map zze = new LinkedHashMap();
    private final zzcb zzg = new zzcb(zzje.zza);
    private final zzjh zzh = zzjh.zzc();
    private final zzij zzi = new zzij(this);

    public zzja(zzek zzekVar, zzbi zzbiVar) {
        this.zzc = zzekVar;
        this.zzq = zzbiVar;
        zzek zzekVarZza = zzekVar.zza();
        zzekVarZza.zzc(zzekVar.zzd());
        this.zzj = zzekVarZza;
        int i4 = zzav.zza;
        this.zzk = k.b(zzis.zza);
        this.zzl = k.b(zzit.zza);
        this.zzm = k.b(zziu.zza);
        this.zzn = k.b(zziv.zza);
        this.zzo = k.b(zziw.zza);
    }

    private final Application zzD() {
        return (Application) this.zzo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzE(com.google.android.recaptcha.internal.zzsc r8, Z2.e r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzim
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzim r0 = (com.google.android.recaptcha.internal.zzim) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzim r0 = new com.google.android.recaptcha.internal.zzim
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            com.google.android.recaptcha.internal.zzja r8 = r0.zzd
            W2.q.b(r9)     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            goto L4f
        L2b:
            r0 = move-exception
            r9 = r0
            goto L69
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            W2.q.b(r9)
            W2.j r9 = r7.zzn     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            java.lang.Object r9 = r9.getValue()     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            com.google.android.recaptcha.internal.zzff r9 = (com.google.android.recaptcha.internal.zzff) r9     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            com.google.android.recaptcha.internal.zzek r2 = r7.zzj     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            r0.zzd = r7     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            r0.zzc = r3     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            java.lang.Object r9 = r9.zzd(r8, r2, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L65
            if (r9 != r1) goto L4e
            return r1
        L4e:
            r8 = r7
        L4f:
            java.lang.String r9 = (java.lang.String) r9     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            com.google.android.recaptcha.internal.zzbi r0 = r8.zzq     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            t3.L r1 = r0.zzb()     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            com.google.android.recaptcha.internal.zzin r4 = new com.google.android.recaptcha.internal.zzin     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            r0 = 0
            r4.<init>(r8, r9, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            t3.AbstractC1818i.d(r1, r2, r3, r4, r5, r6)     // Catch: com.google.android.recaptcha.internal.zzbd -> L2b
            goto L70
        L65:
            r0 = move-exception
            r8 = r0
            r9 = r8
            r8 = r7
        L69:
            t3.x r8 = r8.zzA()
            r8.G(r9)
        L70:
            W2.E r8 = W2.E.f5463a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzE(com.google.android.recaptcha.internal.zzsc, Z2.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzF(java.lang.String r9, Z2.e r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzio
            if (r0 == 0) goto L13
            r0 = r10
            com.google.android.recaptcha.internal.zzio r0 = (com.google.android.recaptcha.internal.zzio) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzio r0 = new com.google.android.recaptcha.internal.zzio
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.zza
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.String r9 = r0.zzf
            java.lang.String r1 = r0.zze
            com.google.android.recaptcha.internal.zzja r2 = r0.zzd
            W2.q.b(r10)     // Catch: java.lang.Exception -> L32
            r3 = r9
            r4 = r1
            r9 = r2
            goto L68
        L32:
            r0 = move-exception
            r9 = r0
            goto L7d
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            W2.q.b(r10)
            com.google.android.recaptcha.internal.zzek r10 = r8.zzj
            r2 = 26
            com.google.android.recaptcha.internal.zzen r10 = r10.zzf(r2)
            r8.zzp = r10
            W2.j r10 = r8.zzl     // Catch: java.lang.Exception -> L7a
            java.lang.Object r10 = r10.getValue()     // Catch: java.lang.Exception -> L7a
            com.google.android.recaptcha.internal.zzbr r10 = (com.google.android.recaptcha.internal.zzbr) r10     // Catch: java.lang.Exception -> L7a
            java.lang.String r10 = r10.zza()     // Catch: java.lang.Exception -> L7a
            r0.zzd = r8     // Catch: java.lang.Exception -> L7a
            r0.zze = r9     // Catch: java.lang.Exception -> L7a
            r0.zzf = r10     // Catch: java.lang.Exception -> L7a
            r0.zzc = r3     // Catch: java.lang.Exception -> L7a
            java.lang.Object r0 = r8.zzw(r0)     // Catch: java.lang.Exception -> L7a
            if (r0 == r1) goto L79
            r4 = r9
            r3 = r10
            r10 = r0
            r9 = r8
        L68:
            r2 = r10
            android.webkit.WebView r2 = (android.webkit.WebView) r2     // Catch: java.lang.Exception -> L74
            java.lang.String r5 = "text/html"
            java.lang.String r6 = "utf-8"
            r7 = 0
            r2.loadDataWithBaseURL(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L74
            goto L9b
        L74:
            r0 = move-exception
            r10 = r0
            r2 = r9
            r9 = r10
            goto L7d
        L79:
            return r1
        L7a:
            r0 = move-exception
            r9 = r0
            r2 = r8
        L7d:
            com.google.android.recaptcha.internal.zzbd r10 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r0 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r1 = com.google.android.recaptcha.internal.zzba.zzU
            java.lang.String r9 = r9.getMessage()
            r10.<init>(r0, r1, r9)
            com.google.android.recaptcha.internal.zzen r9 = r2.zzp
            if (r9 == 0) goto L91
            r9.zzb(r10)
        L91:
            r9 = 0
            r2.zzp = r9
            t3.x r9 = r2.zzA()
            r9.G(r10)
        L9b:
            W2.E r9 = W2.E.f5463a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzF(java.lang.String, Z2.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzG(java.lang.String r9, Z2.e r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzix
            if (r0 == 0) goto L13
            r0 = r10
            com.google.android.recaptcha.internal.zzix r0 = (com.google.android.recaptcha.internal.zzix) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzix r0 = new com.google.android.recaptcha.internal.zzix
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.zza
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.String r9 = r0.zze
            com.google.android.recaptcha.internal.zzja r0 = r0.zzd
            W2.q.b(r10)
            goto L79
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            java.lang.String r9 = r0.zze
            com.google.android.recaptcha.internal.zzja r2 = r0.zzd
            W2.q.b(r10)
            goto L5c
        L40:
            W2.q.b(r10)
            com.google.android.recaptcha.internal.zzcb r10 = r8.zzg
            com.google.android.recaptcha.internal.zzje r2 = com.google.android.recaptcha.internal.zzje.zzd
            com.google.android.recaptcha.internal.zzje r5 = com.google.android.recaptcha.internal.zzje.zzc
            com.google.android.recaptcha.internal.zzje r6 = com.google.android.recaptcha.internal.zzje.zzb
            com.google.android.recaptcha.internal.zzje[] r2 = new com.google.android.recaptcha.internal.zzje[]{r2, r5, r6}
            r0.zzd = r8
            r0.zze = r9
            r0.zzc = r4
            java.lang.Object r10 = r10.zzb(r2, r0)
            if (r10 == r1) goto La0
            r2 = r8
        L5c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L67
            W2.E r9 = W2.E.f5463a
            return r9
        L67:
            com.google.android.recaptcha.internal.zzcb r10 = r2.zzg
            com.google.android.recaptcha.internal.zzje r5 = com.google.android.recaptcha.internal.zzje.zzb
            r0.zzd = r2
            r0.zze = r9
            r0.zzc = r3
            java.lang.Object r10 = r10.zzc(r5, r0)
            if (r10 != r1) goto L78
            goto La0
        L78:
            r0 = r2
        L79:
            r10 = 0
            t3.x r1 = t3.AbstractC1851z.b(r10, r4, r10)
            r0.zza = r1
            com.google.android.recaptcha.internal.zzek r1 = r0.zzj
            r1.zzc(r9)
            r9 = 42
            com.google.android.recaptcha.internal.zzen r9 = r1.zzf(r9)
            com.google.android.recaptcha.internal.zzbi r1 = r0.zzq
            t3.L r2 = r1.zza()
            com.google.android.recaptcha.internal.zziz r5 = new com.google.android.recaptcha.internal.zziz
            r5.<init>(r0, r9, r10)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            t3.AbstractC1818i.d(r2, r3, r4, r5, r6, r7)
            W2.E r9 = W2.E.f5463a
            return r9
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzG(java.lang.String, Z2.e):java.lang.Object");
    }

    public static final /* synthetic */ zzfk zzp(zzja zzjaVar) {
        return (zzfk) zzjaVar.zzm.getValue();
    }

    public final InterfaceC1847x zzA() {
        InterfaceC1847x interfaceC1847x = this.zza;
        if (interfaceC1847x != null) {
            return interfaceC1847x;
        }
        return null;
    }

    public final zzft zzC(zzsc zzscVar, zzcg zzcgVar, WebView webView) {
        zzfw zzfwVar = new zzfw(webView, this.zzq.zzb());
        zzhy zzhyVar = new zzhy();
        zzhyVar.zzb(x.h0(zzscVar.zzP()));
        zzgf zzgfVar = new zzgf(zzfwVar, zzcgVar, new zzbo());
        zzhz zzhzVar = new zzhz(zzhyVar, new zzhw());
        zzgfVar.zze(3, zzD());
        zzgfVar.zze(5, zzig.zza());
        zzgfVar.zze(6, new zzia(zzD()));
        zzgfVar.zze(7, new zzic());
        zzgfVar.zze(8, new zzii(zzD()));
        zzgfVar.zze(9, new zzid(zzD()));
        zzgfVar.zze(10, new zzib(zzD()));
        return new zzft(this.zzq.zzd(), zzgfVar, zzhzVar, zzfn.zza());
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final zzen zza(String str) {
        zzek zzekVar = this.zzc;
        zzekVar.zzc(str);
        return zzekVar.zzf(33);
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final zzen zzb() {
        zzek zzekVar = this.zzc;
        zzekVar.zzc(zzekVar.zzd());
        return zzekVar.zzf(32);
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzd(String str, e eVar) {
        zzsh zzshVarZzf = zzsi.zzf();
        zzshVarZzf.zze(str);
        return zzshVarZzf.zzk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:
    
        if (r8.zzG(r4, r2) != r3) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzf(java.lang.String r18, Z2.e r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzf(java.lang.String, Z2.e):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzg(zzbd zzbdVar, e eVar) {
        if (r.b(zzbdVar.zza(), zzba.zzb)) {
            zzen zzenVar = this.zzp;
            if (zzenVar != null) {
                zzenVar.zzb(zzbdVar);
            }
            this.zzp = null;
        }
        return E.f5463a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (zzG(r6, r0) != r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r6.zzc(r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzh(com.google.android.recaptcha.internal.zzsc r6, Z2.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzir
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzir r0 = (com.google.android.recaptcha.internal.zzir) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzir r0 = new com.google.android.recaptcha.internal.zzir
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            W2.q.b(r7)
            goto L5e
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            W2.q.b(r7)
            goto L74
        L38:
            W2.q.b(r7)
            boolean r7 = r6.zzT()
            if (r7 == 0) goto L67
            boolean r7 = r6.zzR()
            if (r7 == 0) goto L67
            boolean r7 = r6.zzQ()
            if (r7 != 0) goto L4e
            goto L67
        L4e:
            r5.zzf = r6
            com.google.android.recaptcha.internal.zzek r6 = r5.zzc
            java.lang.String r6 = r6.zzd()
            r0.zzc = r3
            java.lang.Object r6 = r5.zzG(r6, r0)
            if (r6 == r1) goto L73
        L5e:
            W2.p$a r6 = W2.p.f5487b
            W2.E r6 = W2.E.f5463a
            java.lang.Object r6 = W2.p.b(r6)
            return r6
        L67:
            com.google.android.recaptcha.internal.zzcb r6 = r5.zzg
            com.google.android.recaptcha.internal.zzje r7 = com.google.android.recaptcha.internal.zzje.zzd
            r0.zzc = r4
            java.lang.Object r6 = r6.zzc(r7, r0)
            if (r6 != r1) goto L74
        L73:
            return r1
        L74:
            W2.p$a r6 = W2.p.f5487b
            com.google.android.recaptcha.internal.zzbd r6 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r7 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzav
            r1 = 0
            r6.<init>(r7, r0, r1)
            java.lang.Object r6 = W2.q.a(r6)
            java.lang.Object r6 = W2.p.b(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzh(com.google.android.recaptcha.internal.zzsc, Z2.e):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzi(String str, long j4, Exception exc, e eVar) {
        exc.getMessage();
        InterfaceC1847x interfaceC1847x = (InterfaceC1847x) this.zze.remove(str);
        if (interfaceC1847x != null) {
            AbstractC0864b.a(interfaceC1847x.G(exc));
        }
        return E.f5463a;
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzj(Exception exc, e eVar) {
        return ((exc instanceof V0) && this.zzi.zza() == null) ? new zzbd(zzbb.zzc, zzba.zzH, null) : zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzV, exc.getMessage()));
    }

    public final zzcb zzm() {
        return this.zzg;
    }

    public final zzij zzq() {
        return this.zzi;
    }

    public final Object zzw(e eVar) {
        return AbstractC1818i.g(this.zzq.zzb().l(), new zzjc((zzjd) this.zzk.getValue(), zzD(), null), eVar);
    }

    public final Object zzx(e eVar) {
        Object objG = AbstractC1818i.g(this.zzq.zzb().l(), new zzil(this, null), eVar);
        return objG == AbstractC0787c.e() ? objG : E.f5463a;
    }
}
