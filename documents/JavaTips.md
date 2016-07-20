### Dependency Injection

#### Inject

* Use @Inject -> eager injection
* Use @Inject Injector injector
  * injector.getInstance(Some.class) - so the instance is created only when it is required and exists only
   in the scope of the creating method or block.   
  
#### Binding

* Use annotated injection binding
  * injects a different instance according to the annotated name

  
```java
//binding:
bind(CategoryTree.class).toProvider(CategoryTreeProvider.class).in(Singleton.class);
bind(CategoryTree.class).annotatedWith(Names.named("new")).toProvider(CategoryTreeInNewProvider.class).in(Singleton.class);
```

```java
// annotated injection:
@Inject
@Named("new")
CategoryTree categoryTree
```
In the above case the second binding is used to inject an instance.

```java
// normal injection:
@Inject
CategoryTree categoryTree
```
In this case the first binding is used to inject an instance.