#SillyHatSwing-Project

Foo/
|-- bin/
|   |-- foo
|
|-- foo/
|   |-- tests/
|   |   |-- __init__.py
|   |   |-- test_main.py
|   |
|   |-- __init__.py
|   |-- main.py
|
|-- docs/
|   |-- conf.py
|   |-- abc.rst
|
|-- setup.py
|-- requirements.txt
|-- READMEbootz   - boot zImage from memory  

/arch           Architecture specific files  

  /arm          Files generic to ARM architecture  
        /cpu        CPU specific files  
      /arm720t      Files specific to ARM 720 CPUs  
      /arm920t      Files specific to ARM 920 CPUs  
      /at91         Files specific to Atmel AT91RM9200 CPU  
      /imx          Files specific to Freescale MC9328 i.MX CPUs  
      /s3c24x0      Files specific to Samsung S3C24X0 CPUs  
    /lib        Architecture specific library files  
  /x86          Files generic to x86 architecture  
    /cpu        CPU specific files  
    /lib        Architecture specific library files  
  /mips         Files generic to MIPS architecture  
    /cpu        CPU specific files  
      /mips32       Files specific to MIPS32 CPUs  
      /xburst       Files specific to Ingenic XBurst CPUs  
    /lib        Architecture specific library files  
  /powerpc      Files generic to PowerPC architecture  
    /cpu        CPU specific files  
      /74xx_7xx     Files specific to Freescale MPC74xx and 7xx CPUs  
      /mpc5xx       Files specific to Freescale MPC5xx CPUs  
      /mpc5xxx      Files specific to Freescale MPC5xxx CPUs  
    /lib        Architecture specific library files  
/api            Machine/arch independent API for external apps  
/board          Board dependent files  
/common         Misc architecture independent functions  
/disk           Code for disk drive partition handling  
/doc            Documentation (don't expect too much)  
/drivers        Commonly used device drivers  
/dts                    Contains Makefile for building internal U-Boot fdt.  
/examples       Example code for standalone applications, etc.  
/fs             Filesystem code (cramfs, ext2, jffs2, etc.)  
/include        Header Files  
/lib            Files generic to all architectures  
  /libfdt       Library files to support flattened device trees  
  /lzma         Library files to support LZMA decompression  
  /lzo          Library files to support LZO decompression  
/net            Networking code  
/post           Power On Self Test  
/rtc            Real Time Clock drivers  
/tools          Tools to build S-Record or U-Boot images, etc.  