.class public final Lze/p;
.super Lgf/i;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lgf/q;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lze/p$b;
    }
.end annotation


# static fields
.field public static final f:Lze/p;

.field public static g:Lgf/r;


# instance fields
.field public final b:Lgf/d;

.field public c:Lgf/n;

.field public d:B

.field public e:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lze/p$a;

    .line 2
    .line 3
    invoke-direct {v0}, Lze/p$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lze/p;->g:Lgf/r;

    .line 7
    .line 8
    new-instance v0, Lze/p;

    .line 9
    .line 10
    const/4 v1, 0x1

    .line 11
    invoke-direct {v0, v1}, Lze/p;-><init>(Z)V

    .line 12
    .line 13
    .line 14
    sput-object v0, Lze/p;->f:Lze/p;

    .line 15
    .line 16
    invoke-direct {v0}, Lze/p;->x()V

    .line 17
    .line 18
    .line 19
    return-void
.end method

.method public constructor <init>(Lgf/e;Lgf/g;)V
    .locals 7

    .line 11
    invoke-direct {p0}, Lgf/i;-><init>()V

    const/4 v0, -0x1

    .line 12
    iput-byte v0, p0, Lze/p;->d:B

    .line 13
    iput v0, p0, Lze/p;->e:I

    .line 14
    invoke-direct {p0}, Lze/p;->x()V

    .line 15
    invoke-static {}, Lgf/d;->v()Lgf/d$b;

    move-result-object v0

    const/4 v1, 0x1

    .line 16
    invoke-static {v0, v1}, Lgf/f;->I(Ljava/io/OutputStream;I)Lgf/f;

    move-result-object v2

    const/4 v3, 0x0

    move v4, v3

    :cond_0
    :goto_0
    if-nez v3, :cond_5

    .line 17
    :try_start_0
    invoke-virtual {p1}, Lgf/e;->J()I

    move-result v5

    if-eqz v5, :cond_1

    const/16 v6, 0xa

    if-eq v5, v6, :cond_2

    .line 18
    invoke-virtual {p0, p1, v2, p2, v5}, Lgf/i;->o(Lgf/e;Lgf/f;Lgf/g;I)Z

    move-result v5

    if-nez v5, :cond_0

    :cond_1
    move v3, v1

    goto :goto_0

    :catchall_0
    move-exception p1

    goto :goto_3

    :catch_0
    move-exception p1

    goto :goto_1

    :catch_1
    move-exception p1

    goto :goto_2

    .line 19
    :cond_2
    invoke-virtual {p1}, Lgf/e;->k()Lgf/d;

    move-result-object v5

    if-eq v4, v1, :cond_3

    .line 20
    new-instance v6, Lgf/m;

    invoke-direct {v6}, Lgf/m;-><init>()V

    iput-object v6, p0, Lze/p;->c:Lgf/n;

    move v4, v1

    .line 21
    :cond_3
    iget-object v6, p0, Lze/p;->c:Lgf/n;

    invoke-interface {v6, v5}, Lgf/n;->B(Lgf/d;)V
    :try_end_0
    .catch Lgf/k; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 22
    :goto_1
    :try_start_1
    new-instance p2, Lgf/k;

    .line 23
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lgf/k;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p0}, Lgf/k;->i(Lgf/p;)Lgf/k;

    move-result-object p1

    throw p1

    .line 24
    :goto_2
    invoke-virtual {p1, p0}, Lgf/k;->i(Lgf/p;)Lgf/k;

    move-result-object p1

    throw p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_3
    if-ne v4, v1, :cond_4

    .line 25
    iget-object p2, p0, Lze/p;->c:Lgf/n;

    invoke-interface {p2}, Lgf/n;->l()Lgf/n;

    move-result-object p2

    iput-object p2, p0, Lze/p;->c:Lgf/n;

    .line 26
    :cond_4
    :try_start_2
    invoke-virtual {v2}, Lgf/f;->H()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 27
    :catch_2
    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lze/p;->b:Lgf/d;

    goto :goto_4

    :catchall_1
    move-exception p1

    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lze/p;->b:Lgf/d;

    .line 28
    throw p1

    .line 29
    :goto_4
    invoke-virtual {p0}, Lgf/i;->l()V

    .line 30
    throw p1

    :cond_5
    if-ne v4, v1, :cond_6

    .line 31
    iget-object p1, p0, Lze/p;->c:Lgf/n;

    invoke-interface {p1}, Lgf/n;->l()Lgf/n;

    move-result-object p1

    iput-object p1, p0, Lze/p;->c:Lgf/n;

    .line 32
    :cond_6
    :try_start_3
    invoke-virtual {v2}, Lgf/f;->H()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 33
    :catch_3
    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p1

    iput-object p1, p0, Lze/p;->b:Lgf/d;

    goto :goto_5

    :catchall_2
    move-exception p1

    invoke-virtual {v0}, Lgf/d$b;->u()Lgf/d;

    move-result-object p2

    iput-object p2, p0, Lze/p;->b:Lgf/d;

    .line 34
    throw p1

    .line 35
    :goto_5
    invoke-virtual {p0}, Lgf/i;->l()V

    return-void
.end method

.method public synthetic constructor <init>(Lgf/e;Lgf/g;Lze/a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lze/p;-><init>(Lgf/e;Lgf/g;)V

    return-void
.end method

.method public constructor <init>(Lgf/i$b;)V
    .locals 1

    .line 3
    invoke-direct {p0, p1}, Lgf/i;-><init>(Lgf/i$b;)V

    const/4 v0, -0x1

    .line 4
    iput-byte v0, p0, Lze/p;->d:B

    .line 5
    iput v0, p0, Lze/p;->e:I

    .line 6
    invoke-virtual {p1}, Lgf/i$b;->i()Lgf/d;

    move-result-object p1

    iput-object p1, p0, Lze/p;->b:Lgf/d;

    return-void
.end method

.method public synthetic constructor <init>(Lgf/i$b;Lze/a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Lze/p;-><init>(Lgf/i$b;)V

    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0

    .line 7
    invoke-direct {p0}, Lgf/i;-><init>()V

    const/4 p1, -0x1

    .line 8
    iput-byte p1, p0, Lze/p;->d:B

    .line 9
    iput p1, p0, Lze/p;->e:I

    .line 10
    sget-object p1, Lgf/d;->a:Lgf/d;

    iput-object p1, p0, Lze/p;->b:Lgf/d;

    return-void
.end method

.method public static synthetic q(Lze/p;)Lgf/n;
    .locals 0

    .line 1
    iget-object p0, p0, Lze/p;->c:Lgf/n;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic r(Lze/p;Lgf/n;)Lgf/n;
    .locals 0

    .line 1
    iput-object p1, p0, Lze/p;->c:Lgf/n;

    .line 2
    .line 3
    return-object p1
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method

.method public static synthetic s(Lze/p;)Lgf/d;
    .locals 0

    .line 1
    iget-object p0, p0, Lze/p;->b:Lgf/d;

    .line 2
    .line 3
    return-object p0
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
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static t()Lze/p;
    .locals 1

    .line 1
    sget-object v0, Lze/p;->f:Lze/p;

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
    .line 17
    .line 18
    .line 19
.end method

.method private x()V
    .locals 1

    .line 1
    sget-object v0, Lgf/m;->b:Lgf/n;

    .line 2
    .line 3
    iput-object v0, p0, Lze/p;->c:Lgf/n;

    .line 4
    .line 5
    return-void
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
    .line 17
    .line 18
    .line 19
.end method

.method public static y()Lze/p$b;
    .locals 1

    .line 1
    invoke-static {}, Lze/p$b;->l()Lze/p$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public static z(Lze/p;)Lze/p$b;
    .locals 1

    .line 1
    invoke-static {}, Lze/p;->y()Lze/p$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0, p0}, Lze/p$b;->t(Lze/p;)Lze/p$b;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    return-object p0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public A()Lze/p$b;
    .locals 1

    .line 1
    invoke-static {}, Lze/p;->y()Lze/p$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public B()Lze/p$b;
    .locals 1

    .line 1
    invoke-static {p0}, Lze/p;->z(Lze/p;)Lze/p$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public b()I
    .locals 3

    .line 1
    iget v0, p0, Lze/p;->e:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-eq v0, v1, :cond_0

    .line 5
    .line 6
    return v0

    .line 7
    :cond_0
    const/4 v0, 0x0

    .line 8
    move v1, v0

    .line 9
    :goto_0
    iget-object v2, p0, Lze/p;->c:Lgf/n;

    .line 10
    .line 11
    invoke-interface {v2}, Ljava/util/List;->size()I

    .line 12
    .line 13
    .line 14
    move-result v2

    .line 15
    if-ge v0, v2, :cond_1

    .line 16
    .line 17
    iget-object v2, p0, Lze/p;->c:Lgf/n;

    .line 18
    .line 19
    invoke-interface {v2, v0}, Lgf/n;->H(I)Lgf/d;

    .line 20
    .line 21
    .line 22
    move-result-object v2

    .line 23
    invoke-static {v2}, Lgf/f;->e(Lgf/d;)I

    .line 24
    .line 25
    .line 26
    move-result v2

    .line 27
    add-int/2addr v1, v2

    .line 28
    add-int/lit8 v0, v0, 0x1

    .line 29
    .line 30
    goto :goto_0

    .line 31
    :cond_1
    invoke-virtual {p0}, Lze/p;->w()Lgf/s;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 36
    .line 37
    .line 38
    move-result v0

    .line 39
    add-int/2addr v1, v0

    .line 40
    iget-object v0, p0, Lze/p;->b:Lgf/d;

    .line 41
    .line 42
    invoke-virtual {v0}, Lgf/d;->size()I

    .line 43
    .line 44
    .line 45
    move-result v0

    .line 46
    add-int/2addr v1, v0

    .line 47
    iput v1, p0, Lze/p;->e:I

    .line 48
    .line 49
    return v1
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
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method public bridge synthetic c()Lgf/p$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lze/p;->A()Lze/p$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public final d()Z
    .locals 2

    .line 1
    iget-byte v0, p0, Lze/p;->d:B

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    return v1

    .line 7
    :cond_0
    if-nez v0, :cond_1

    .line 8
    .line 9
    const/4 v0, 0x0

    .line 10
    return v0

    .line 11
    :cond_1
    iput-byte v1, p0, Lze/p;->d:B

    .line 12
    .line 13
    return v1
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public bridge synthetic f()Lgf/p$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lze/p;->B()Lze/p$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 17
    .line 18
    .line 19
.end method

.method public g(Lgf/f;)V
    .locals 3

    .line 1
    invoke-virtual {p0}, Lze/p;->b()I

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    :goto_0
    iget-object v1, p0, Lze/p;->c:Lgf/n;

    .line 6
    .line 7
    invoke-interface {v1}, Ljava/util/List;->size()I

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    if-ge v0, v1, :cond_0

    .line 12
    .line 13
    iget-object v1, p0, Lze/p;->c:Lgf/n;

    .line 14
    .line 15
    invoke-interface {v1, v0}, Lgf/n;->H(I)Lgf/d;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    const/4 v2, 0x1

    .line 20
    invoke-virtual {p1, v2, v1}, Lgf/f;->N(ILgf/d;)V

    .line 21
    .line 22
    .line 23
    add-int/lit8 v0, v0, 0x1

    .line 24
    .line 25
    goto :goto_0

    .line 26
    :cond_0
    iget-object v0, p0, Lze/p;->b:Lgf/d;

    .line 27
    .line 28
    invoke-virtual {p1, v0}, Lgf/f;->h0(Lgf/d;)V

    .line 29
    .line 30
    .line 31
    return-void
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
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
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
.end method

.method public v(I)Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lze/p;->c:Lgf/n;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    check-cast p1, Ljava/lang/String;

    .line 8
    .line 9
    return-object p1
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public w()Lgf/s;
    .locals 1

    .line 1
    iget-object v0, p0, Lze/p;->c:Lgf/n;

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
    .line 17
    .line 18
    .line 19
.end method
