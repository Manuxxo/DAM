# futuros tókens
#personajes = ['mago', 'guerrero', 'doncella', 'tendero']
with open("personajes.txt","r") as fich_personajes:
    lista_personajes = fich_personajes.readlines()
    personajes = []
    personaje_futuro = ""
    for i in lista_personajes:
        personaje_futuro = i.rstrip('\n')
        personajes.append(personaje_futuro)

#objeto = ['llave', 'cofre', 'candelabro', 'pistola', 'cuchillo', 'pan', 'agua']
with open("objetos.txt","r") as fich_objetos:
    lista_objetos = fich_objetos.readlines()
    objeto = []
    objeto_futuro = ""
    for i in lista_personajes:
        objeto_futuro = i.rstrip('\n')
        objeto.append(objeto_futuro)




# futuros tókens
verbo = ['dar', 'abrir', 'cerrar', 'coger', 'hablar', 'mirar', 'usar', 'empujar', 'tirar']
verbosdireccion = ['ir']
comando = ['inventario', 'nuevo', 'guardar', 'cargar', 'mapa', 'ayuda']
conjunciones = ['a', 'con']
verbosmercado = ['comprar', 'vender']
ordenes = ['si', 'no']
direccion = ['norte', 'sur', 'este', 'oeste']

# reglas grámaticales

procesoverbos = ['objeto', 'personaje', 'conjuncion', 'comando']
procesodireccion = ['norte', 'sur', 'este', 'oeste']
procesoconjuncion = ['personaje', 'objeto']
procesospersonaje = ['conjuncion', '']
procesosverbosmercado = ['objeto']
procesoobjeto = ['conjuncion']
proceso_palabra_final = ['personaje', 'objeto', 'direccion', 'ordenes', 'comando']


# compruebo que todas las palabras esten dentro de los tokens

def validacionsintaxis(lista):
    for i in lista:
        if i in verbo or i in personajes or i in comando or i in verbosdireccion or i in objeto or i in conjunciones or i in verbosmercado or i in ordenes or i in direccion:
            return True
        else:
            return False


# compruebo que la frase tenga sentido semanticamente

def validadcionsemantica(lista):
    token = []
    # creo la lista de token
    for i in lista:
        if i in verbo:
            token.append('verbo')
        elif i in comando:
            token.append('comando')
        elif i in verbosdireccion:
            token.append('verbosdireccion')
        elif i in objeto:
            token.append('objeto')
        elif i in conjunciones:
            token.append('conjuncion')
        elif i in verbosmercado:
            token.append('verbosmercado')
        elif i in ordenes:
            token.append('ordenes')
        elif i in direccion:
            token.append('direccion')
        elif i in personajes:
            token.append('personaje')
    longitud = len(token)
    contador = 1

    # primer token
    # no puede ser un objeto, direccion, personaje o conjuncion
    correcto = False
    if token[contador - 1] == 'objeto':
        correcto = False
        return correcto
    if token[contador - 1] == 'direccion':
        correcto = False
        return correcto
    if token[contador - 1] == 'personaje':
        correcto = False
        return correcto
    if token[contador - 1] == 'conjuncion':
        correcto = False
        return correcto

    # del segundo token al final
    #

    while contador < longitud - 1:
        if token[contador] == 'verbo':
            if not token[contador + 1] in procesoverbos:
                correcto = False
                return correcto
        elif token[contador] == 'ordenes':
            if longitud > 1:
                correcto = False
                return correcto
            else:
                correcto = True
                return correcto
        elif token[contador] == 'verbosmercado':
            if token[contador + 1] in procesosverbosmercado:
                correcto = True
                return correcto
            else:
                correcto = False
                return correcto
        elif token[contador] == 'personaje':
            if not token[contador + 1] in procesospersonaje:
                correcto = False
                return correcto
        elif token[contador] == 'verbosdireccion':
            if not token[contador + 1] in direccion:
                correcto = False
                return correcto
        elif token[contador] == 'objeto':
            if not token[contador + 1] in procesoobjeto:
                correcto = False
                return correcto
        elif token[contador] == 'conjuncion':
            if not token[contador + 1] in procesoconjuncion:
                correcto = False
                return correcto
        elif token[contador] == 'direccion':
            if longitud > 2:
                correcto = False
                return correcto
            else:
                correcto = True

        contador = contador + 1

    if len(token) == 1:
        if token[contador - 1] in procesopalabrafinal:
            return True
        else:
            return False
    else:
        if token[contador] in procesopalabrafinal:
            return True
        else:
            return False

def main():
    with open("a.txt", "r") as fich_entrada:
        lista = fich_entrada.readlines()
        lista_salida = []
        contador = len(lista)
        contado2 = 0
        while contador > 0:
            lista_comprobacion = lista[contado2].rstrip('\n')
            lista_comprobacion = lista_comprobacion.split(" ")
            correcto_sintaxis = validacionsintaxis(lista_comprobacion)
            correcto_semantica = False
            if correcto_sintaxis:
                correcto_semantica = validadcionsemantica(lista_comprobacion)
            if correcto_semantica:
                lista_salida.append("Correcto\n")
            else:
                lista_salida.append("Error\n")
            contador = contador - 1
            contado2 = contado2 + 1
    with open("a2.txt", "w") as fich_salida:
        for i in lista_salida:
            fich_salida.write(i)

main()
