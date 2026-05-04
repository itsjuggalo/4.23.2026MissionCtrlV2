.class public final Lt0/j0$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lt0/j0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lt0/j0$f;


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x22

    if-lt v0, v1, :cond_0

    .line 3
    new-instance v0, Lt0/j0$e;

    invoke-direct {v0}, Lt0/j0$e;-><init>()V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void

    :cond_0
    const/16 v1, 0x1e

    if-lt v0, v1, :cond_1

    .line 4
    new-instance v0, Lt0/j0$d;

    invoke-direct {v0}, Lt0/j0$d;-><init>()V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void

    :cond_1
    const/16 v1, 0x1d

    if-lt v0, v1, :cond_2

    .line 5
    new-instance v0, Lt0/j0$c;

    invoke-direct {v0}, Lt0/j0$c;-><init>()V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void

    .line 6
    :cond_2
    new-instance v0, Lt0/j0$b;

    invoke-direct {v0}, Lt0/j0$b;-><init>()V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void
.end method

.method public constructor <init>(Lt0/j0;)V
    .locals 2

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x22

    if-lt v0, v1, :cond_0

    .line 9
    new-instance v0, Lt0/j0$e;

    invoke-direct {v0, p1}, Lt0/j0$e;-><init>(Lt0/j0;)V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void

    :cond_0
    const/16 v1, 0x1e

    if-lt v0, v1, :cond_1

    .line 10
    new-instance v0, Lt0/j0$d;

    invoke-direct {v0, p1}, Lt0/j0$d;-><init>(Lt0/j0;)V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void

    :cond_1
    const/16 v1, 0x1d

    if-lt v0, v1, :cond_2

    .line 11
    new-instance v0, Lt0/j0$c;

    invoke-direct {v0, p1}, Lt0/j0$c;-><init>(Lt0/j0;)V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void

    .line 12
    :cond_2
    new-instance v0, Lt0/j0$b;

    invoke-direct {v0, p1}, Lt0/j0$b;-><init>(Lt0/j0;)V

    iput-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    return-void
.end method


# virtual methods
.method public a()Lt0/j0;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$f;->b()Lt0/j0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public b(Ll0/b;)Lt0/j0$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$f;->d(Ll0/b;)V

    .line 4
    .line 5
    .line 6
    return-object p0
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
.end method

.method public c(Ll0/b;)Lt0/j0$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0$a;->a:Lt0/j0$f;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$f;->f(Ll0/b;)V

    .line 4
    .line 5
    .line 6
    return-object p0
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
.end method
