.class public final synthetic Lm7/c2;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public synthetic a:Lcom/google/firebase/auth/b$b;

.field public synthetic b:La7/m;


# direct methods
.method public synthetic constructor <init>(Lcom/google/firebase/auth/b$b;La7/m;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lm7/c2;->a:Lcom/google/firebase/auth/b$b;

    .line 5
    .line 6
    iput-object p2, p0, Lm7/c2;->b:La7/m;

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
.method public final run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lm7/c2;->a:Lcom/google/firebase/auth/b$b;

    .line 2
    .line 3
    iget-object v1, p0, Lm7/c2;->b:La7/m;

    .line 4
    .line 5
    invoke-virtual {v0, v1}, Lcom/google/firebase/auth/b$b;->onVerificationFailed(La7/m;)V

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
.end method
