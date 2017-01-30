# meta-guh

Yocto layer for guh (unofficial)

## Dependencies

To prepare your environment please follow the instructions at https://www.yoctoproject.org/docs/1.8/yocto-project-qs/yocto-project-qs.html#ubuntu

## Bulding the image
```bash
$ mkdir guh-build
$ cd guh-build
$ repo init -u https://github.com/gustavosbarreto/meta-guh.git
$ repo sync
$ bitbake guh-image
```
