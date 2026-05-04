.class public Lcom/amazon/device/drm/a/a/a;
.super Lcom/amazon/a/a/n/a/h;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field private static final c:Ljava/lang/String; = "a"

.field private static final d:Ljava/lang/String; = "get_license"

.field private static final e:Ljava/lang/String; = "1.0"


# instance fields
.field b:Lcom/amazon/a/a/h/c;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private f:Landroid/app/Application;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private g:Lcom/amazon/a/a/o/b/b;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .line 1
    return-void
    .line 2
    .line 3
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public constructor <init>(Lcom/amazon/device/drm/a/b/b;)V
    .locals 7

    .line 1
    invoke-virtual {p1}, Lcom/amazon/device/drm/a/b/b;->d()Lcom/amazon/device/drm/model/RequestId;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Lcom/amazon/device/drm/model/RequestId;->toString()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v5

    .line 9
    const-string v6, "2.9.0.0"

    .line 10
    .line 11
    const-string v3, "get_license"

    .line 12
    .line 13
    const-string v4, "1.0"

    .line 14
    .line 15
    move-object v1, p0

    .line 16
    move-object v2, p1

    .line 17
    invoke-direct/range {v1 .. v6}, Lcom/amazon/a/a/n/a/h;-><init>(Lcom/amazon/a/a/j/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    const/4 p1, 0x0

    .line 21
    invoke-virtual {p0, p1}, Lcom/amazon/a/a/n/a/h;->b(Z)V

    .line 22
    .line 23
    .line 24
    return-void
.end method

.method private a(Lcom/amazon/a/b/g;)Lcom/amazon/a/b/b;
    .locals 2

    .line 15
    :try_start_0
    iget-object v0, p0, Lcom/amazon/device/drm/a/a/a;->g:Lcom/amazon/a/a/o/b/b;

    invoke-interface {v0}, Lcom/amazon/a/a/o/b/b;->a()Ljava/security/PublicKey;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/a;->a(Lcom/amazon/a/b/g;Ljava/security/PublicKey;)Lcom/amazon/a/b/b;

    move-result-object p1
    :try_end_0
    .catch Lcom/amazon/a/a/o/b/a/c; {:try_start_0 .. :try_end_0} :catch_2
    .catch Lcom/amazon/a/a/o/b/a/b; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lcom/amazon/a/a/o/b/a/a; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    return-object p1

    :catch_0
    move-exception p1

    goto :goto_0

    :catch_1
    move-exception p1

    goto :goto_1

    :catch_2
    move-exception p1

    goto :goto_2

    .line 16
    :catch_3
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v0, "Content License returned from Appstore is not in proper format"

    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    goto :goto_3

    .line 18
    :goto_0
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v1, "Unable to load the public key from the apk"

    invoke-static {v0, v1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    sget-object v0, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_INVALID_LICENSING_KEYS:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, v0}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 20
    iget-object v0, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/n/a/a;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/h/a;

    move-result-object p1

    invoke-interface {v0, p1}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    goto :goto_3

    .line 21
    :goto_1
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v1, "Unable to parse the license returned by Appstore Client"

    invoke-static {v0, v1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    sget-object v0, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, v0}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 23
    iget-object v0, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/n/a/a;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/h/a;

    move-result-object p1

    invoke-interface {v0, p1}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    goto :goto_3

    .line 24
    :goto_2
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v1, "Unable to decode the license with the public key provided by the developer"

    invoke-static {v0, v1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    sget-object v0, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_INVALID_LICENSING_KEYS:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, v0}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 26
    iget-object v0, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/n/a/a;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/h/a;

    move-result-object p1

    invoke-interface {v0, p1}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    :goto_3
    const/4 p1, 0x0

    return-object p1
.end method

.method private a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V
    .locals 3

    .line 1
    invoke-virtual {p0}, Lcom/amazon/a/a/n/a/h;->j()Lcom/amazon/a/a/j/a;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/drm/a/b/b;

    .line 2
    new-instance v1, Lcom/amazon/device/drm/a/c/a;

    invoke-direct {v1}, Lcom/amazon/device/drm/a/c/a;-><init>()V

    .line 3
    invoke-virtual {v0}, Lcom/amazon/device/drm/a/b/b;->d()Lcom/amazon/device/drm/model/RequestId;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/drm/a/c/a;->a(Lcom/amazon/device/drm/model/RequestId;)Lcom/amazon/device/drm/a/c/a;

    move-result-object v1

    .line 4
    invoke-virtual {v1, p1}, Lcom/amazon/device/drm/a/c/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)Lcom/amazon/device/drm/a/c/a;

    move-result-object p1

    .line 5
    invoke-virtual {p1}, Lcom/amazon/device/drm/a/c/a;->a()Lcom/amazon/device/drm/model/LicenseResponse;

    move-result-object p1

    .line 6
    invoke-virtual {v0}, Lcom/amazon/device/drm/a/b/b;->a()Lcom/amazon/a/a/j/b;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/a/a/j/b;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private a(Lcom/amazon/a/b/g;Lcom/amazon/a/b/b;)Z
    .locals 3

    const/4 v0, 0x0

    if-nez p2, :cond_0

    return v0

    .line 7
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/amazon/device/drm/a/a/a;->f:Landroid/app/Application;

    invoke-static {p1, p2, v1}, Lcom/amazon/device/drm/a/e/a;->a(Lcom/amazon/a/b/g;Lcom/amazon/a/b/b;Landroid/app/Application;)V
    :try_end_0
    .catch Lcom/amazon/a/b/a/a; {:try_start_0 .. :try_end_0} :catch_0

    const/4 p1, 0x1

    return p1

    :catch_0
    move-exception p1

    .line 8
    invoke-virtual {p1}, Lcom/amazon/a/b/a/a;->d()Lcom/amazon/a/a/o/d/c;

    move-result-object p2

    sget-object v1, Lcom/amazon/a/b/h;->a:Lcom/amazon/a/b/h;

    invoke-virtual {p2, v1}, Lcom/amazon/a/a/o/d/c;->a(Lcom/amazon/a/a/o/d/b;)Z

    move-result p2

    if-eqz p2, :cond_1

    .line 9
    sget-object p2, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v1, "License has expired"

    invoke-static {p2, v1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 10
    iget-object p2, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/n/a/a;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/h/a;

    move-result-object p1

    invoke-interface {p2, p1}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    .line 11
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->EXPIRED:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    goto :goto_0

    .line 12
    :cond_1
    sget-object p2, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "License Verification failed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Lcom/amazon/a/b/a/a;->d()Lcom/amazon/a/a/o/d/c;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2, v1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 13
    iget-object p2, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/n/a/a;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/h/a;

    move-result-object p1

    invoke-interface {p2, p1}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    .line 14
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    :goto_0
    return v0
.end method


# virtual methods
.method public b(Lcom/amazon/d/a/h;)V
    .locals 3

    .line 10
    :try_start_0
    invoke-interface {p1}, Lcom/amazon/d/a/h;->g()Ljava/lang/String;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 11
    :try_start_1
    invoke-static {p1}, Lcom/amazon/a/a/n/a/g;->valueOf(Ljava/lang/String;)Lcom/amazon/a/a/n/a/g;

    move-result-object p1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 12
    sget-object v0, Lcom/amazon/device/drm/a/a/a$1;->a:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 13
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v0, "No valid failure reason found. Defaulting to UNKNOWN_ERROR"

    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 14
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->UNKNOWN_ERROR:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    return-void

    .line 15
    :pswitch_0
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object p1

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object p1

    const-string v1, "Unable to verify Application metadata: %s"

    invoke-static {v1, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    return-void

    .line 17
    :pswitch_1
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object p1

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object p1

    const-string v1, "Unable to verify Device info: %s"

    invoke-static {v1, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    return-void

    .line 19
    :pswitch_2
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object p1

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object p1

    const-string v1, "Customer is not licensed to use the Application: %s"

    invoke-static {v1, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 20
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->NOT_LICENSED:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    return-void

    .line 21
    :pswitch_3
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object p1

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object p1

    const-string v1, "License has expired: %s"

    invoke-static {v1, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->EXPIRED:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    return-void

    .line 23
    :catch_0
    const-string p1, "Unknown"

    .line 24
    :catch_1
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown Reason of failure"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    iget-object p1, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    new-instance v0, Lcom/amazon/a/a/n/a/a/i;

    const-string v1, "get_license"

    invoke-direct {v0, v1}, Lcom/amazon/a/a/n/a/a/i;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/n/a/a;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/h/a;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public b(Lcom/amazon/d/a/j;)Z
    .locals 3

    .line 1
    sget-object v0, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onResult: result = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    .line 2
    :try_start_0
    new-instance v2, Lcom/amazon/a/b/g;

    invoke-interface {p1}, Lcom/amazon/d/a/j;->b()Ljava/util/Map;

    move-result-object p1

    invoke-direct {v2, p1}, Lcom/amazon/a/b/g;-><init>(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3
    invoke-direct {p0, v2}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/a/b/g;)Lcom/amazon/a/b/b;

    move-result-object p1

    .line 4
    invoke-direct {p0, v2, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/a/b/g;Lcom/amazon/a/b/b;)Z

    move-result p1

    if-nez p1, :cond_0

    return v1

    .line 5
    :cond_0
    const-string p1, "License Verification was successful"

    invoke-static {v0, p1}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    iget-object p1, p0, Lcom/amazon/device/drm/a/a/a;->b:Lcom/amazon/a/a/h/c;

    new-instance v0, Lcom/amazon/a/b/b/a;

    invoke-direct {v0}, Lcom/amazon/a/b/b/a;-><init>()V

    invoke-interface {p1, v0}, Lcom/amazon/a/a/h/c;->a(Lcom/amazon/a/a/h/a;)V

    .line 7
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->LICENSED:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    const/4 p1, 0x1

    return p1

    .line 8
    :catch_0
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    const-string v0, "License not returned by Appstore"

    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 9
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->NOT_LICENSED:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    return v1
.end method

.method public c(Lcom/amazon/a/a/d/b;)V
    .locals 2

    .line 1
    invoke-virtual {p1}, Lcom/amazon/a/a/d/b;->a()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "EXCEPTION_RESULT_FAILURE"

    .line 6
    .line 7
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    if-eqz v1, :cond_1

    .line 12
    .line 13
    invoke-virtual {p1}, Lcom/amazon/a/a/d/b;->b()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    sparse-switch v0, :sswitch_data_0

    .line 22
    .line 23
    .line 24
    goto :goto_1

    .line 25
    :sswitch_0
    const-string v0, "INTERNAL_SERVICE_ERROR"

    .line 26
    .line 27
    :goto_0
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 28
    .line 29
    .line 30
    move-result p1

    .line 31
    goto :goto_1

    .line 32
    :sswitch_1
    const-string v0, "UNKNOWN"

    .line 33
    .line 34
    goto :goto_0

    .line 35
    :sswitch_2
    const-string v0, "NO_INTERNET"

    .line 36
    .line 37
    goto :goto_0

    .line 38
    :sswitch_3
    const-string v0, "INVALID_CONTENT_ID"

    .line 39
    .line 40
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 41
    .line 42
    .line 43
    move-result p1

    .line 44
    if-eqz p1, :cond_0

    .line 45
    .line 46
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    .line 47
    .line 48
    const-string v0, "Unable to verify Application metadata"

    .line 49
    .line 50
    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    .line 52
    .line 53
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    .line 54
    .line 55
    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 56
    .line 57
    .line 58
    return-void

    .line 59
    :cond_0
    :goto_1
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    .line 60
    .line 61
    const-string v0, "No valid failure reason found. Defaulting to UNKNOWN_ERROR"

    .line 62
    .line 63
    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    .line 65
    .line 66
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->UNKNOWN_ERROR:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    .line 67
    .line 68
    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 69
    .line 70
    .line 71
    return-void

    .line 72
    :cond_1
    const-string p1, "AUTH_TOKEN_VERIFICATION_FAILURE"

    .line 73
    .line 74
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 75
    .line 76
    .line 77
    move-result p1

    .line 78
    if-eqz p1, :cond_2

    .line 79
    .line 80
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    .line 81
    .line 82
    const-string v0, "AuthToken verification failed"

    .line 83
    .line 84
    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    .line 86
    .line 87
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_VERIFICATION:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    .line 88
    .line 89
    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 90
    .line 91
    .line 92
    return-void

    .line 93
    :cond_2
    const-string p1, "DATA_AUTH_KEY_LOAD_FAILURE"

    .line 94
    .line 95
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 96
    .line 97
    .line 98
    move-result p1

    .line 99
    if-eqz p1, :cond_3

    .line 100
    .line 101
    sget-object p1, Lcom/amazon/device/drm/a/a/a;->c:Ljava/lang/String;

    .line 102
    .line 103
    const-string v0, "Unable to load the public key from the apk"

    .line 104
    .line 105
    invoke-static {p1, v0}, Lcom/amazon/device/drm/a/e/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    .line 107
    .line 108
    sget-object p1, Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;->ERROR_INVALID_LICENSING_KEYS:Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;

    .line 109
    .line 110
    invoke-direct {p0, p1}, Lcom/amazon/device/drm/a/a/a;->a(Lcom/amazon/device/drm/model/LicenseResponse$RequestStatus;)V

    .line 111
    .line 112
    .line 113
    :cond_3
    return-void

    .line 114
    nop

    .line 115
    :sswitch_data_0
    .sparse-switch
        -0x3cfc41d7 -> :sswitch_3
        0x166347ff -> :sswitch_2
        0x19d1382a -> :sswitch_1
        0x7a9405bc -> :sswitch_0
    .end sparse-switch
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
.end method

.method public f()Z
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    return v0
    .line 3
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
