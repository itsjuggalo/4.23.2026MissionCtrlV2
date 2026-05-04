.class public Lb9/i;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ly8/h;


# instance fields
.field public a:Z

.field public b:Z

.field public c:Ly8/d;

.field public final d:Lb9/f;


# direct methods
.method public constructor <init>(Lb9/f;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lb9/i;->a:Z

    .line 6
    .line 7
    iput-boolean v0, p0, Lb9/i;->b:Z

    .line 8
    .line 9
    iput-object p1, p0, Lb9/i;->d:Lb9/f;

    .line 10
    .line 11
    return-void
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


# virtual methods
.method public final a()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lb9/i;->a:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x1

    .line 6
    iput-boolean v0, p0, Lb9/i;->a:Z

    .line 7
    .line 8
    return-void

    .line 9
    :cond_0
    new-instance v0, Ly8/c;

    .line 10
    .line 11
    const-string v1, "Cannot encode a second value in the ValueEncoderContext"

    .line 12
    .line 13
    invoke-direct {v0, v1}, Ly8/c;-><init>(Ljava/lang/String;)V

    .line 14
    .line 15
    .line 16
    throw v0
.end method

.method public b(Ly8/d;Z)V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Lb9/i;->a:Z

    .line 3
    .line 4
    iput-object p1, p0, Lb9/i;->c:Ly8/d;

    .line 5
    .line 6
    iput-boolean p2, p0, Lb9/i;->b:Z

    .line 7
    .line 8
    return-void
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
.end method

.method public f(Ljava/lang/String;)Ly8/h;
    .locals 3

    .line 1
    invoke-virtual {p0}, Lb9/i;->a()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lb9/i;->d:Lb9/f;

    .line 5
    .line 6
    iget-object v1, p0, Lb9/i;->c:Ly8/d;

    .line 7
    .line 8
    iget-boolean v2, p0, Lb9/i;->b:Z

    .line 9
    .line 10
    invoke-virtual {v0, v1, p1, v2}, Lb9/f;->o(Ly8/d;Ljava/lang/Object;Z)Ly8/f;

    .line 11
    .line 12
    .line 13
    return-object p0
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

.method public g(Z)Ly8/h;
    .locals 3

    .line 1
    invoke-virtual {p0}, Lb9/i;->a()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lb9/i;->d:Lb9/f;

    .line 5
    .line 6
    iget-object v1, p0, Lb9/i;->c:Ly8/d;

    .line 7
    .line 8
    iget-boolean v2, p0, Lb9/i;->b:Z

    .line 9
    .line 10
    invoke-virtual {v0, v1, p1, v2}, Lb9/f;->l(Ly8/d;ZZ)Lb9/f;

    .line 11
    .line 12
    .line 13
    return-object p0
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
