.class public Lh8/q$e$d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lh8/q$e;->c(Ls8/e;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ls8/e;

.field public final synthetic b:Lh8/q$e;


# direct methods
.method public constructor <init>(Lh8/q$e;Ls8/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lh8/q$e$d;->b:Lh8/q$e;

    .line 2
    .line 3
    iput-object p2, p0, Lh8/q$e$d;->a:Ls8/e;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
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


# virtual methods
.method public run()V
    .locals 4

    .line 1
    iget-object v0, p0, Lh8/q$e$d;->a:Ls8/e;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const/4 v1, 0x0

    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Lh8/q$e$d;->a:Ls8/e;

    .line 11
    .line 12
    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    instance-of v0, v0, Ljava/io/EOFException;

    .line 17
    .line 18
    if-eqz v0, :cond_0

    .line 19
    .line 20
    iget-object v0, p0, Lh8/q$e$d;->b:Lh8/q$e;

    .line 21
    .line 22
    iget-object v0, v0, Lh8/q$e;->b:Lh8/q;

    .line 23
    .line 24
    invoke-static {v0}, Lh8/q;->c(Lh8/q;)Lq8/c;

    .line 25
    .line 26
    .line 27
    move-result-object v0

    .line 28
    const-string v2, "WebSocket reached EOF."

    .line 29
    .line 30
    new-array v1, v1, [Ljava/lang/Object;

    .line 31
    .line 32
    invoke-virtual {v0, v2, v1}, Lq8/c;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 33
    .line 34
    .line 35
    goto :goto_0

    .line 36
    :cond_0
    iget-object v0, p0, Lh8/q$e$d;->b:Lh8/q$e;

    .line 37
    .line 38
    iget-object v0, v0, Lh8/q$e;->b:Lh8/q;

    .line 39
    .line 40
    invoke-static {v0}, Lh8/q;->c(Lh8/q;)Lq8/c;

    .line 41
    .line 42
    .line 43
    move-result-object v0

    .line 44
    iget-object v2, p0, Lh8/q$e$d;->a:Ls8/e;

    .line 45
    .line 46
    new-array v1, v1, [Ljava/lang/Object;

    .line 47
    .line 48
    const-string v3, "WebSocket error."

    .line 49
    .line 50
    invoke-virtual {v0, v3, v2, v1}, Lq8/c;->a(Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V

    .line 51
    .line 52
    .line 53
    :goto_0
    iget-object v0, p0, Lh8/q$e$d;->b:Lh8/q$e;

    .line 54
    .line 55
    iget-object v0, v0, Lh8/q$e;->b:Lh8/q;

    .line 56
    .line 57
    invoke-static {v0}, Lh8/q;->g(Lh8/q;)V

    .line 58
    .line 59
    .line 60
    return-void
    .line 61
.end method
