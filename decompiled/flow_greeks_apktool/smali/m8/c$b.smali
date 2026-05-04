.class public Lm8/c$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/util/concurrent/ThreadFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lm8/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "b"
.end annotation


# instance fields
.field public final synthetic a:Lm8/c;


# direct methods
.method public constructor <init>(Lm8/c;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lm8/c$b;->a:Lm8/c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lm8/c;Lm8/c$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Lm8/c$b;-><init>(Lm8/c;)V

    return-void
.end method


# virtual methods
.method public newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;
    .locals 2

    .line 1
    iget-object v0, p0, Lm8/c$b;->a:Lm8/c;

    .line 2
    .line 3
    invoke-virtual {v0}, Lm8/c;->e()Ljava/util/concurrent/ThreadFactory;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-interface {v0, p1}, Ljava/util/concurrent/ThreadFactory;->newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    iget-object v0, p0, Lm8/c$b;->a:Lm8/c;

    .line 12
    .line 13
    invoke-virtual {v0}, Lm8/c;->f()Lj8/a0;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    const-string v1, "FirebaseDatabaseWorker"

    .line 18
    .line 19
    invoke-interface {v0, p1, v1}, Lj8/a0;->a(Ljava/lang/Thread;Ljava/lang/String;)V

    .line 20
    .line 21
    .line 22
    const/4 v1, 0x1

    .line 23
    invoke-interface {v0, p1, v1}, Lj8/a0;->b(Ljava/lang/Thread;Z)V

    .line 24
    .line 25
    .line 26
    new-instance v1, Lm8/c$b$a;

    .line 27
    .line 28
    invoke-direct {v1, p0}, Lm8/c$b$a;-><init>(Lm8/c$b;)V

    .line 29
    .line 30
    .line 31
    invoke-interface {v0, p1, v1}, Lj8/a0;->c(Ljava/lang/Thread;Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 32
    .line 33
    .line 34
    return-object p1
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
.end method
