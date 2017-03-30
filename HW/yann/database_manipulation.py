import numpy
import csv
#table1 = open('Product.csv', 'rb')
#table2 = open('Soldvia.csv', 'rb')
#reader1 = csv.DictReader(table1)
#reader2 = csv.DictReader(table2)


def innitialation(key, table):
    #turn tuple with same key to list
    hashtable = {}
    for row in table:
        real_key = ''
        for name in key:
            real_key += row[name]
            if real_key in hashtable:
                hashtable[real_key].append(row.values())
            else:
                hashtable.update({real_key: [row.values()]})
    return hashtable


def main():
    string1= raw_input('please input the address of First table')
    string2= raw_input('please input the address of Second table')
    table1 = open(string1, 'rb')
    table2 = open(string2, 'rb')
    reader1 = csv.DictReader(table1)
    reader2 = csv.DictReader(table2)

    print ("===================================================\n"+
          "This is the result of Nature Join\n"+
          "===================================================\n")
    #test select
    select(['vendorid'], '*', 'productprice', reader1, ['vendorid'])
    # print the  result of nature join
    list_nature_join =  outjoin(reader1, reader2)
    for i in range(len(list_nature_join)):
        print list_nature_join[i]

    print ("===================================================\n"+
          "This is the result of Out Join\n"+
          "===================================================\n")


    #print the result of outjoin
    list_outjoin =  outjoin(reader1, reader2)
    for i in range(len(list_outjoin)):
        print list_outjoin[i]
    #print len(outjoin(reader1, reader2))


def outjoin(reader1, reader2):
    equal_column = []
    tuplelist = []
    #find the common key
    for name1 in reader1.fieldnames:
        for name2 in reader2.fieldnames:
            if name1.upper() == name2.upper():
                equal_column.append(name1)
    if len(equal_column) == 0:
        print("failed")
    else:
        # turn list into hashtable, key in common key
        hashtable1 = innitialation(equal_column, reader1)
        hashtable2 = innitialation(equal_column, reader2)
        for key in hashtable1:
            #join common key
            if key in hashtable2:
                for i in range(len(hashtable1[key])):
                    for j in range(len(hashtable2[key])):
                        tuple_ = hashtable1[key][i] + hashtable2[key][j]
                        tuplelist.append(tuple_)
                        pass
            else:
                #join different key in table1
                for i in range(len(hashtable1[key])):
                    tuple_ = dict(zip(reader2.fieldnames, [None] * len(reader2.fieldnames)))
                    tuplelist.append(hashtable1[key][i] + tuple_.values())
        #join different key in table2
        for key in hashtable2:
            if key in hashtable1:
                pass
            else:
                for i in range(len(hashtable2[key])):
                    tuple_ = dict(zip(reader1.fieldnames, [None] * len(reader1.fieldnames)))
                    tuplelist.append(tuple_.values() + hashtable2[key][i])

        return tuplelist


def _in(name, destination, dictionary):  # dictionary gotten from prerequsit
    for row in dectionation:
        if row[name] in dictionary:
            return True
        else:
            return False


def nature_join(reader1, reader2):
    equal_column = []
    tuplelist = []
     #find the common key
    for name1 in reader1.fieldnames:
        for name2 in reader2.fieldnames:
            if name1.upper() == name2.upper():
                equal_column.append(name1)
    if len(equal_column) == 0:
        print("failed")
    else:
        # turn list into hashtable, key in common key
        hashtable1 = innitialation(equal_column, reader1)
        hashtable2 = innitialation(equal_column, reader2)
        #join common key in different table
        for key in hashtable1:
            if key in hashtable2:
                for i in range(len(hashtable1[key])):
                    for j in range(len(hashtable2[key])):
                        tuple_ = hashtable1[key][i] + hashtable2[key][j]
                        tuplelist.append(tuple_)
                        pass
        return tuplelist


def select(entity, count, avg, destination, groupby):
    if count != 'null' or avg != 'null':
        if groupby == 'null' or groupby != entity:
            print('syntax wrong')
        else:
            count_c = {}
            entity_c = {}
            list_index = []
            avg_c = {}
            try:
                for row in destination:
                    index = ''
                    entity_list = []
                    for column in entity:
                        index += row[column]
                        entity_list.append(row[column])
                    if index in count_c:
                        count_c[index] += 1
                        avg_c[index] += float(row[avg])
                    else:
                        avg_c.update({index: float(row[avg])})
                        list_index.append(index)
                        count_c.update({index: 1})
                        entity_c.update({index: entity_list})
                for i in range(len(list_index)):
                    #  print avg_c
                    print (list_index[i], count_c[list_index[i]], avg_c[list_index[i]] / count_c[list_index[i]])
                    # print entity_c[list_index[i]]
                    # print count_c[list_index[i]]
            except Exception as e:
                print(e)
                print("attibute not in row")

    else:
        content = ''
        try:
            for row in destination:
                content += ('\n')
                for column in entity:
                    content += (row[column] + '\t' * 2)
            print content
        except Exception as e:
            print('attrubutes not in row2')


main()
