package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String ap;

    @Column(nullable = false, length = 100)
    private String am;

    @Column(nullable = false, unique = true, length = 13)
    private String rfc;

    @Column(nullable = false, unique = true, length = 11)
    private String nss;

    @Column(length = 15)
    private String tel;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getAp() { return ap; }
    public void setAp(String ap) { this.ap = ap; }

    public String getAm() { return am; }
    public void setAm(String am) { this.am = am; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getNss() { return nss; }
    public void setNss(String nss) { this.nss = nss; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
}
