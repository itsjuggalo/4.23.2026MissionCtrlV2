.class public Lcom/google/firebase/firestore/f;
.super La7/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/firebase/firestore/f$a;
    }
.end annotation


# instance fields
.field public final a:Lcom/google/firebase/firestore/f$a;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/google/firebase/firestore/f$a;)V
    .locals 2

    .line 1
    invoke-direct {p0, p1}, La7/m;-><init>(Ljava/lang/String;)V

    .line 2
    const-string v0, "Provided message must not be null."

    invoke-static {p1, v0}, Ln9/x;->c(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3
    sget-object p1, Lcom/google/firebase/firestore/f$a;->b:Lcom/google/firebase/firestore/f$a;

    const/4 v0, 0x0

    if-eq p2, p1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    move p1, v0

    :goto_0
    const-string v1, "A FirebaseFirestoreException should never be thrown for OK"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {p1, v1, v0}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 4
    const-string p1, "Provided code must not be null."

    invoke-static {p2, p1}, Ln9/x;->c(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/firebase/firestore/f$a;

    iput-object p1, p0, Lcom/google/firebase/firestore/f;->a:Lcom/google/firebase/firestore/f$a;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/google/firebase/firestore/f$a;Ljava/lang/Throwable;)V
    .locals 1

    .line 5
    invoke-direct {p0, p1, p3}, La7/m;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 6
    const-string p3, "Provided message must not be null."

    invoke-static {p1, p3}, Ln9/x;->c(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 7
    sget-object p1, Lcom/google/firebase/firestore/f$a;->b:Lcom/google/firebase/firestore/f$a;

    const/4 p3, 0x0

    if-eq p2, p1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    move p1, p3

    :goto_0
    const-string v0, "A FirebaseFirestoreException should never be thrown for OK"

    new-array p3, p3, [Ljava/lang/Object;

    invoke-static {p1, v0, p3}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 8
    const-string p1, "Provided code must not be null."

    invoke-static {p2, p1}, Ln9/x;->c(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/firebase/firestore/f$a;

    iput-object p1, p0, Lcom/google/firebase/firestore/f;->a:Lcom/google/firebase/firestore/f$a;

    return-void
.end method


# virtual methods
.method public a()Lcom/google/firebase/firestore/f$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/firebase/firestore/f;->a:Lcom/google/firebase/firestore/f$a;

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
