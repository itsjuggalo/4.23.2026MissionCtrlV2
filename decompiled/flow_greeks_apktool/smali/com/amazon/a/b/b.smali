.class public Lcom/amazon/a/b/b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/util/Date;

.field private final e:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/a/a/o/b/f;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const-string v0, "checksum"

    .line 5
    .line 6
    invoke-direct {p0, v0, p1}, Lcom/amazon/a/b/b;->a(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/lang/String;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    iput-object v0, p0, Lcom/amazon/a/b/b;->a:Ljava/lang/String;

    .line 11
    .line 12
    const-string v0, "customerId"

    .line 13
    .line 14
    invoke-direct {p0, v0, p1}, Lcom/amazon/a/b/b;->a(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    iput-object v0, p0, Lcom/amazon/a/b/b;->b:Ljava/lang/String;

    .line 19
    .line 20
    const-string v0, "deviceId"

    .line 21
    .line 22
    invoke-direct {p0, v0, p1}, Lcom/amazon/a/b/b;->a(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    iput-object v0, p0, Lcom/amazon/a/b/b;->c:Ljava/lang/String;

    .line 27
    .line 28
    const-string v0, "packageName"

    .line 29
    .line 30
    invoke-direct {p0, v0, p1}, Lcom/amazon/a/b/b;->a(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/lang/String;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    iput-object v0, p0, Lcom/amazon/a/b/b;->e:Ljava/lang/String;

    .line 35
    .line 36
    const-string v0, "expiration"

    .line 37
    .line 38
    invoke-direct {p0, v0, p1}, Lcom/amazon/a/b/b;->b(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/util/Date;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    iput-object p1, p0, Lcom/amazon/a/b/b;->d:Ljava/util/Date;

    .line 43
    .line 44
    return-void
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
.end method

.method private a(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/lang/String;
    .locals 1

    .line 1
    invoke-virtual {p2, p1}, Lcom/amazon/a/a/o/b/f;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 2
    invoke-static {p2}, Lcom/amazon/a/a/o/e;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    return-object p2

    .line 3
    :cond_0
    invoke-static {p1}, Lcom/amazon/a/a/o/b/a/b;->a(Ljava/lang/String;)Lcom/amazon/a/a/o/b/a/b;

    move-result-object p1

    throw p1
.end method

.method private b(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/util/Date;
    .locals 3

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/amazon/a/b/b;->a(Ljava/lang/String;Lcom/amazon/a/a/o/b/f;)Ljava/lang/String;

    move-result-object p2

    .line 2
    :try_start_0
    new-instance v0, Ljava/util/Date;

    invoke-static {p2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 3
    :catch_0
    invoke-static {p1, p2}, Lcom/amazon/a/a/o/b/a/b;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/a/a/o/b/a/b;

    move-result-object p1

    throw p1
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .line 4
    iget-object v0, p0, Lcom/amazon/a/b/b;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .line 4
    iget-object v0, p0, Lcom/amazon/a/b/b;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/amazon/a/b/b;->c:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
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

.method public d()Ljava/util/Date;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/amazon/a/b/b;->d:Ljava/util/Date;

    .line 2
    .line 3
    return-object v0
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

.method public e()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/amazon/a/b/b;->e:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
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
