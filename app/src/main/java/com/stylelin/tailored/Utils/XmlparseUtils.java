package com.stylelin.tailored.Utils;

/**
 * 创建人: nicolas
 * 创建时间:2016年7月14日 下午2:17:41
 * 类描述:xml文件解析
 */
public class XmlparseUtils {
   /* private XmlparseUtils() {
        *//* cannot be instantiated *//*
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static List<Map<String, String>> parseFromAssets(Context context, String fileName, String elementsByTagName) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        Map<String, String> map = null;

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(context.getAssets().open(fileName));
            Element rootElement = doc.getDocumentElement();
            NodeList items = rootElement.getElementsByTagName(elementsByTagName);
            for (int i = 0; i < items.getLength(); i++) {
                map = new HashMap<String, String>();
                Node item = items.item(i);
                NodeList properties = item.getChildNodes();
                for (int j = 0; j < properties.getLength(); j++) {
                    Node property = properties.item(j);
                    String nodeName = property.getNodeName();
                    if (nodeName.equals(Constants.REQUESTURLFILEPARSEFIELD)) {
                        map.put(nodeName, property.getFirstChild().getNodeValue());
                    }
                }
                list.add(map);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Map<String, String>> parseFromSDCard(String filePath, String elementsByTagName) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new FileInputStream(filePath));
            Element rootElement = doc.getDocumentElement();
            NodeList items = rootElement.getElementsByTagName(elementsByTagName);
            for (int i = 0; i < items.getLength(); i++) {
                Map<String, String> map = new HashMap<String, String>();
                Node item = items.item(i);
                NodeList properties = item.getChildNodes();
                for (int j = 0; j < properties.getLength(); j++) {
                    Node property = properties.item(j);
                    String nodeName = property.getNodeName();
                    map.put(nodeName, property.getFirstChild().getNodeValue());
                }
                list.add(map);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }*/
}